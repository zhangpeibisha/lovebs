package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.EvaluationQuestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.security.UserDetail;
import org.nix.lovedomain.service.constant.CacheConstant;
import org.nix.lovedomain.service.vo.EvaluationalSimpleVo;
import org.nix.lovedomain.service.vo.EvaluationquestionnaireDeatilVo;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.TeacherSimpleVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class EvaluationQuestionnaireService {

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationquestionnaireBusinessMapper;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    /**
     * 添加评教卷，主要用于老师创建评教卷开始的步骤
     *
     * @param title       评教卷题目
     * @param description 评教卷描述
     * @param principal   用户信息
     * @return 添加数量
     */
    @CacheEvict(cacheNames = CacheConstant.EVALUATIONAL_PAGE, allEntries = true)
    public EvaluationQuestionnaireModel createSimpleQuestion(String title,
                                                             String description,
                                                             Principal principal) {
        EvaluationQuestionnaireModel evaluationQuestionnaireModel = new EvaluationQuestionnaireModel();
        evaluationQuestionnaireModel.setTitle(title);

        // 创建评教卷的用户
        evaluationQuestionnaireModel.setAuthorAccountId(UserDetail.analysisUserAccountId(principal));

        evaluationQuestionnaireModel.setDescription(description);

        evaluationQuestionnaireBusinessMapper.insertSelective(evaluationQuestionnaireModel);
        return evaluationQuestionnaireModel;
    }

    /**
     * 添加选择题类型的问题
     *
     * @param question 添加问题信息
     * @return 评教卷全部数据
     */
    public EvaluationQuestionnaireModel addQuestion(Integer questionId,
                                                    List<BaseQuestion> question,
                                                    Principal principal) {
        EvaluationQuestionnaireModel questionnaireModel
                = getEvaluationalById(questionId, principal);
        EvaluationQuestionnaireContent contentBean =
                EvaluationQuestionnaireContent.getContentBean(questionnaireModel);
        contentBean.addQuestions(question);
        questionnaireModel.setContent(JSONUtil.toJsonStr(contentBean));
        evaluationQuestionnaireBusinessMapper.updateByPrimaryKeySelective(questionnaireModel);
        return questionnaireModel;
    }


    /**
     * 通过用户评教卷id得到评教卷
     *
     * @param questionId 评教卷id
     * @param principal  用户信息
     * @return 评教卷全部内容
     */
    public EvaluationQuestionnaireModel getEvaluationalById(Integer questionId,
                                                            Principal principal) {
        Validator.validateNotNull(principal, "用户未登录查询的评教卷{}", questionId);
        EvaluationQuestionnaireModel evaluationQuestionnaireModel
                = evaluationquestionnaireBusinessMapper.selectByPrimaryKey(questionId);
        if (evaluationQuestionnaireModel == null) {
            throw new ServiceException(
                    LogUtil.logInfo(log, "用户{}需要查询的评教卷{}不存在", principal.getName(), questionId));
        }
        return evaluationQuestionnaireModel;
    }

    /**
     * 获取一个详细的评教卷信息
     * 由于评教卷不会被更新和删除，所以只需要缓存就可以了
     * @param questionId
     * @param principal
     * @return
     */
    @Cacheable(cacheNames = CacheConstant.EVALUATIONAL_DETAIL, key = "#questionId")
    public EvaluationquestionnaireDeatilVo getEvaluationsDeathVoById(Integer questionId,
                                                                     Principal principal) {
        EvaluationQuestionnaireModel questionnaireModel
                = getEvaluationalById(questionId, principal);
        EvaluationalSimpleVo simpleVoById = findEvaluationQuestionHaveTeacherInfo(questionId);
        EvaluationquestionnaireDeatilVo evaluationquestionnaireDeatilVo
                = JSONUtil.toBean(JSONUtil.toJsonStr(simpleVoById), EvaluationquestionnaireDeatilVo.class);
        evaluationquestionnaireDeatilVo.setContent(questionnaireModel.getContent());
        return evaluationquestionnaireDeatilVo;
    }

    /**
     * 获取一个包含了老师信息的评教卷
     *
     * @param questionId 评教卷id
     * @return 评教卷信息
     */
    public EvaluationalSimpleVo findEvaluationQuestionHaveTeacherInfo(Integer questionId) {
        EvaluationQuestionnaireModel evaluationQuestionnaireModel
                = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(questionId);
        if (evaluationQuestionnaireModel == null) {
            return null;
        }
        Integer authorAccountId = evaluationQuestionnaireModel.getAuthorAccountId();

        TeacherModel teacher = teacherBusinessMapper.selectByAccountId(authorAccountId);
        if (teacher == null) {
            return null;
        }
        // 老师的简约信息
        TeacherSimpleVo teacherSimpleVo = new TeacherSimpleVo();
        teacherSimpleVo.setId(teacher.getId());
        teacherSimpleVo.setImageUrl(teacher.getImageUrl());
        teacherSimpleVo.setJobNumber(teacher.getJobNumber());
        teacherSimpleVo.setName(teacher.getName());

        // 老师的联系方式
        TeacherSimpleVo.Correspondence correspondence = new TeacherSimpleVo.Correspondence();
        correspondence.setEmail(teacher.getEmail());
        correspondence.setPhone(teacher.getPhone());

        teacherSimpleVo.setCorrespondence(correspondence);

        EvaluationalSimpleVo evaluationalSimpleVo
                = JSONUtil.toBean(JSONUtil.toJsonStr(evaluationQuestionnaireModel),
                EvaluationalSimpleVo.class);

        // 设置作者信息
        evaluationalSimpleVo.setAuthor(teacherSimpleVo);

        // 设置创建时间
        Date createTime = evaluationQuestionnaireModel.getCreateTime();
        evaluationalSimpleVo.setCreateTime(DateUtil.format(createTime, "yyyy-MM-dd HH:mm:SS"));

        return evaluationalSimpleVo;
    }

    /**
     * 分页查询评教卷信息
     * 评教卷不会被删除，且查询频率足够，因此应该添加缓存
     * 在添加的时候需要删除所有缓存{@link EvaluationQuestionnaireService#createSimpleQuestion(String, String, Principal)}
     *
     * @param page     当前页（以1开始）
     * @param limit    每页数量
     * @param querySql 查询sql(where后面的语句)
     * @return 返回结果
     */
    @Cacheable(cacheNames = CacheConstant.EVALUATIONAL_PAGE, key = "#page+'-'+#limit+'-'+#querySql")
    public PageVo<EvaluationalSimpleVo> findAllEvaluationalPage(Integer page,
                                                                Integer limit,
                                                                String querySql) {

        List<EvaluationQuestionnaireModel> list
                = evaluationquestionnaireBusinessMapper.selectPage(SQLUtil.getOffset(page, limit), limit, querySql);

        if (CollUtil.isEmpty(list)) {
            return PageVo.<EvaluationalSimpleVo>builder()
                    .data(CollUtil.newArrayList())
                    .limit(limit)
                    .total(0L)
                    .page(page).build();
        }

        List<EvaluationalSimpleVo> result = new ArrayList<>(list.size());
        for (EvaluationQuestionnaireModel evaluational : list) {
            EvaluationalSimpleVo simpleVoById = findEvaluationQuestionHaveTeacherInfo(evaluational.getId());
            result.add(simpleVoById);
        }

        Long allCount = evaluationquestionnaireBusinessMapper.selectCountBySql(querySql);
        return PageVo.<EvaluationalSimpleVo>builder()
                .data(result)
                .limit(limit)
                .total(allCount)
                .page(page).build();
    }

}
