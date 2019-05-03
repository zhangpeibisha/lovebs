package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.EvaluationquestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.model.TeacherExample;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.EvaluationquestionnaireSimpleVo;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.TeacherSimpleVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class EvaluationquestionnaireService extends BaseService<Evaluationquestionnaire> {

    @Resource
    private EvaluationquestionnaireMapper evaluationquestionnaireMapper;

    @Autowired
    private AccountService accountService;

    @Resource
    private EvaluationquestionnaireBusinessMapper evaluationquestionnaireBusinessMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private AccountMapper accountMapper;

    /**
     * 添加问卷，主要用于老师创建问卷开始的步骤
     *
     * @param title       问卷题目
     * @param description 问卷描述
     * @param principal   用户信息
     * @return 添加数量
     * @throws Exception 执行添加操作失败
     */
    public Evaluationquestionnaire createSimpleQuestion(String title,
                                                        String description,
                                                        Principal principal) throws Exception {
        if (principal == null) {
            LogUtil.logErr(log, "class:EvaluationquestionnaireService method:createSimpleQuestion用户未登录即可访问，请检查权限控制是否正确");
            throw new ServiceException("当前用户未登陆，不可以创建问卷");
        }
        Evaluationquestionnaire evaluationquestionnaire = new Evaluationquestionnaire();
        evaluationquestionnaire.setTitle(title);
        String userName = principal.getName();
        Account userByAccount = accountService.findUserByAccount(userName);
        evaluationquestionnaire.setAuthorid(String.valueOf(userByAccount.getId()));
        evaluationquestionnaire.setDescritption(description);
        Date createtime = new Date();
        evaluationquestionnaire.setCreatetime(createtime);
        evaluationquestionnaireMapper.insertSelective(evaluationquestionnaire);
        return evaluationquestionnaire;
    }

    /**
     * 添加选择题类型的问题
     *
     * @param question 添加问题信息
     * @return 问卷全部数据
     */
    public Evaluationquestionnaire addQuestion(Integer questionId,
                                               List<BaseQuestion> question,
                                               Principal principal) {
        Evaluationquestionnaire evaluationquestionnaire
                = getEvaluationquestionnaireById(questionId, principal);
        EvaluationQuestionnaireContent contentBean =
                EvaluationQuestionnaireContent.getContentBean(evaluationquestionnaire);
        contentBean.setQuestions(question);
        evaluationquestionnaire.setContent(JSONUtil.toJsonStr(contentBean));
        evaluationquestionnaireMapper.updateByPrimaryKeySelective(evaluationquestionnaire);
        return evaluationquestionnaire;
    }

    /**
     * 更新问卷中的问题信息
     *
     * @param questionId   问卷id
     * @param baseQuestion 问题信息，必须携带id
     * @param principal    用户信息
     * @return 完整的问卷
     */
    public Evaluationquestionnaire updateQuestionItem(Integer questionId,
                                                      BaseQuestion<? extends BaseItem> baseQuestion,
                                                      Principal principal) {
        Evaluationquestionnaire evaluationquestionnaire
                = getEvaluationquestionnaireById(questionId, principal);
        EvaluationQuestionnaireContent contentBean
                = EvaluationQuestionnaireContent.getContentBean(evaluationquestionnaire);
        contentBean.updateQuestion(baseQuestion);
        evaluationquestionnaire.setContent(JSONUtil.toJsonStr(contentBean));
        evaluationquestionnaireMapper.updateByPrimaryKeySelective(evaluationquestionnaire);
        return evaluationquestionnaire;
    }

    public Evaluationquestionnaire deleteQuestionItem(Integer questionId,
                                                      BaseQuestion<? extends BaseItem> baseQuestion,
                                                      Principal principal) {
        Evaluationquestionnaire evaluationquestionnaire
                = getEvaluationquestionnaireById(questionId, principal);
        EvaluationQuestionnaireContent contentBean
                = EvaluationQuestionnaireContent.getContentBean(evaluationquestionnaire);
        contentBean.deleteQuestion(baseQuestion);
        evaluationquestionnaire.setContent(JSONUtil.toJsonStr(contentBean));
        evaluationquestionnaireMapper.updateByPrimaryKeySelective(evaluationquestionnaire);
        return evaluationquestionnaire;
    }

    /**
     * 通过用户问卷id得到问卷
     *
     * @param questionId 问卷id
     * @param principal  用户信息
     * @return 问卷全部内容
     */
    public Evaluationquestionnaire getEvaluationquestionnaireById(Integer questionId,
                                                                  Principal principal) {
        if (principal == null) {
            throw new ServiceException(
                    LogUtil.logWarn(log, "用户未登录查询的问卷{}", questionId));
        }
        Evaluationquestionnaire evaluationquestionnaire = findById(questionId);
        if (evaluationquestionnaire == null) {
            throw new ServiceException(
                    LogUtil.logInfo(log, "用户{}需要查询的问卷{}不存在", principal.getName(), questionId));
        }
        return evaluationquestionnaire;
    }


    public PageVo<EvaluationquestionnaireSimpleVo> findOwnEvaluationquestionnairePage(Principal principal,
                                                                                      Integer page,
                                                                                      Integer limit,
                                                                                      String sql,
                                                                                      Boolean like) {
        if (principal == null) {
            throw new ServiceException("用户未登录无法查询自己的问卷");
        }
        Account userByAccount = accountService.findUserByAccount(principal.getName());
        TeacherExample example = new TeacherExample();
        example.createCriteria().andAccountidEqualTo(userByAccount.getId());
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (CollUtil.isEmpty(teachers) || teachers.size() > 1) {
            return PageVo.<EvaluationquestionnaireSimpleVo>builder()
                    .data(CollUtil.newArrayList())
                    .limit(limit)
                    .total(0L)
                    .page(page).build();
        }
        Teacher teacher = teachers.get(0);
        Integer teacherId = teacher.getId();
        if (sql == null || "".equals(sql)) {
            return findAllEvaluationquestionnairePage(page, limit,
                    StrUtil.format(" where authorid={}", teacherId), like);
        }
        Map<String, Object> map = JSONUtil.toBean(sql, Map.class);
        map.put("authorid", teacherId);
        return findAllEvaluationquestionnairePage(page, limit, JSONUtil.toJsonStr(map), like);
    }

    @Autowired
    private TeacherService teacherService;
    /**
     * 获取一个较为详细的问卷信息
     * @param id
     * @return
     */
    public EvaluationquestionnaireSimpleVo findSimpleVoById(Integer id){
        Evaluationquestionnaire evaluationquestionnaire
                = evaluationquestionnaireMapper.selectByPrimaryKey(id);
        if (evaluationquestionnaire == null){
            return null;
        }
        String authorid = evaluationquestionnaire.getAuthorid();
        if (authorid == null) {
            return null;
        }
        Teacher teacher = teacherService.findTeacherByAccountId(Integer.parseInt(authorid));
        if (teacher == null) {
            return null;
        }
        TeacherSimpleVo teacherSimpleVo = new TeacherSimpleVo();
        teacherSimpleVo.setId(teacher.getId());
        teacherSimpleVo.setImageUrl(teacher.getImagerurl());
        teacherSimpleVo.setJobNumber(teacher.getJobnumber());
        teacherSimpleVo.setName(teacher.getName());

        Integer accountid = teacher.getAccountid();
        Account account = accountMapper.selectByPrimaryKey(accountid);
        if (account == null) {
            return null;
        }
        TeacherSimpleVo.Correspondence correspondence = new TeacherSimpleVo.Correspondence();
        correspondence.setEmail(account.getEmail());
        correspondence.setPhone(account.getPhone());
        teacherSimpleVo.setCorrespondence(correspondence);

        EvaluationquestionnaireSimpleVo evaluationquestionnaireSimpleVo
                = JSONUtil.toBean(JSONUtil.toJsonStr(evaluationquestionnaire),
                EvaluationquestionnaireSimpleVo.class);
        evaluationquestionnaireSimpleVo.setAuthor(teacherSimpleVo);
        return evaluationquestionnaireSimpleVo;
    }

    /**
     * 分页查询问卷信息
     *
     * @param page     当前页（以1开始）
     * @param limit    每页数量
     * @param querySql 查询sql(where后面的语句)
     * @return 返回结果
     */
    public PageVo<EvaluationquestionnaireSimpleVo> findAllEvaluationquestionnairePage(Integer page,
                                                                                      Integer limit,
                                                                                      String querySql,
                                                                                      Boolean like) {
        querySql = resolveQuireSql(querySql, like);

        List<Evaluationquestionnaire> list
                = evaluationquestionnaireBusinessMapper.selectPage(SQLUtil.getOffset(page, limit), limit, querySql);

        if (CollUtil.isEmpty(list)) {
            return PageVo.<EvaluationquestionnaireSimpleVo>builder()
                    .data(CollUtil.newArrayList())
                    .limit(limit)
                    .total(0L)
                    .page(page).build();
        }

        List<EvaluationquestionnaireSimpleVo> result = new ArrayList<>(list.size());
        for (Evaluationquestionnaire evaluationquestionnaire : list) {
            EvaluationquestionnaireSimpleVo simpleVoById = findSimpleVoById(evaluationquestionnaire.getId());
            result.add(simpleVoById);
        }

        Long allCount = evaluationquestionnaireBusinessMapper.selectCount(querySql);
        return PageVo.<EvaluationquestionnaireSimpleVo>builder()
                .data(result)
                .limit(limit)
                .total(allCount)
                .page(page).build();
    }

    public String resolveQuireSql(String quireSql,
                                  Boolean like) {
        if (quireSql == null || "".equals(quireSql)) {
            return "";
        }
        StringBuilder sql = new StringBuilder("where").append(" ");
        Map<String, Object> map = JSONUtil.toBean(quireSql, Map.class);
        if (like) {
            for (Map.Entry<String, Object> sqlMap : map.entrySet()) {
                String key = sqlMap.getKey();
                Object value = sqlMap.getValue();
                sql.append(key).append(" LIKE ").append("'%").append(value).append("%'").append(" ").append("AND").append(" ");
            }
        } else {
            for (Map.Entry<String, Object> sqlMap : map.entrySet()) {
                String key = sqlMap.getKey();
                Object value = sqlMap.getValue();
                sql.append(key).append(" = ").append(value).append(" ").append("AND").append(" ");
            }
        }
        if (sql.length() > 0) {
            sql.delete(sql.lastIndexOf("A"), sql.lastIndexOf(" "));
        }
        return sql.toString();
    }


}
