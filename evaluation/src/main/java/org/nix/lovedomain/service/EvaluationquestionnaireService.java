package org.nix.lovedomain.service;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.utils.LogUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Date;

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
        evaluationquestionnaire.setAuthorid(userName);
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
                                               BaseQuestion<? extends BaseItem> question,
                                               Principal principal) {
        Evaluationquestionnaire evaluationquestionnaire
                = getEvaluationquestionnaireById(questionId, principal);
        EvaluationQuestionnaireContent contentBean =
                EvaluationQuestionnaireContent.getContentBean(evaluationquestionnaire);
        contentBean.addQuestion(question);
        evaluationquestionnaire.setContent(JSONUtil.toJsonStr(contentBean));
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
    public Evaluationquestionnaire updateQuestionChosestionItem(Integer questionId,
                                                                BaseQuestion<? extends BaseItem> baseQuestion,
                                                                Principal principal) {
        Evaluationquestionnaire evaluationquestionnaireById
                = getEvaluationquestionnaireById(questionId, principal);
        EvaluationQuestionnaireContent contentBean = EvaluationQuestionnaireContent.getContentBean(evaluationquestionnaireById);
        contentBean.updateQuestion(baseQuestion);
        return evaluationquestionnaireById;
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
        Evaluationquestionnaire evaluationquestionnaire = findById(questionId);
        if (evaluationquestionnaire == null) {
            throw new ServiceException(
                    LogUtil.logInfo(log, "用户{}需要查询的问卷{}不存在", principal.getName(), questionId));
        }
        return evaluationquestionnaire;
    }

}
