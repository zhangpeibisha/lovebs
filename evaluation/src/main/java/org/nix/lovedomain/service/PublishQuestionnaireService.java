package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.*;
import org.nix.lovedomain.dao.business.json.question.ChoseQuestionItem;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.business.json.student.StudentTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.model.*;
import org.nix.lovedomain.service.vo.*;
import org.nix.lovedomain.utils.ListUtils;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PublishQuestionnaireService {

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @Resource
    private CourseBusinessMapper courseBusinessMapper;

    @Autowired
    private TeacherService teacherService;

    @Resource
    private EvaluationQuestionnaireService evaluationquestionnaireService;

    @Resource
    private StatisticsScoreBusinessMapper statisticsScoreBusinessMapper;

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    /**
     * 添加黑名单学生
     *
     * @param publishId         发布id
     * @param studentAccountIds 学生账户id集合
     * @return 处理后的数据
     */
    public PublishQuestionnaireModel addBlack(Integer publishId,
                                              List<Integer> studentAccountIds,
                                              Principal principal) {
        PublishQuestionnaireModel questionnaireModel
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);
        Validator.validateNotNull(questionnaireModel, "评教卷{}不存在", publishId);
        checkPermission(questionnaireModel, principal);

        PublishAttachInfo bean = PublishAttachInfo.getBean(questionnaireModel);
        bean.addBlackStudent(studentAccountIds);
        questionnaireModel.setStatistics(JSONUtil.toJsonStr(bean));
        publishQuestionBusinessMapper.updateByPrimaryKeySelective(questionnaireModel);
        return PublishQuestionJsonVo.publication2Vo(questionnaireModel);
    }

    /**
     * 删除黑名单学生
     *
     * @param publishId  发布id
     * @param studentIds 学生账户id集合
     * @return 处理后的数据
     */
    public PublishQuestionnaireModel deleteBlack(Integer publishId,
                                                 List<Integer> studentIds,
                                                 Principal principal) {
        PublishQuestionnaireModel questionnaireModel
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);
        Validator.validateNotNull(questionnaireModel, "评教卷{}不存在", publishId);
        checkPermission(questionnaireModel, principal);

        PublishAttachInfo bean = PublishAttachInfo.getBean(questionnaireModel);
        bean.deleteBlackStudent(studentIds);
        questionnaireModel.setStatistics(JSONUtil.toJsonStr(bean));
        publishQuestionBusinessMapper.updateByPrimaryKey(questionnaireModel);
        return questionnaireModel;
    }

    /**
     * 检测这个老师是否可以配置这个发布评教卷
     *
     * @param questionnaireModel 发布的评教卷西悉尼
     * @param principal          登陆用户信息
     */
    public void checkPermission(PublishQuestionnaireModel questionnaireModel,
                                Principal principal) {
        AccountModel teacherAccount = accountService.findUserByAccount(principal.getName());
        Integer teacherAccountId = teacherAccount.getId();
        Validator.validateTrue(teacherAccountId.equals(questionnaireModel.getTeacherAccountId()),
                "问卷{}不应该有授课老师{}来进行操作", questionnaireModel.getId(), teacherAccountId);
    }


    /**
     * 提交回答信息，
     *
     * @param publishId
     * @param completesQuestion
     * @return
     */
    public PublishQuestionnaireModel fillInTheAnswer(Integer publishId,
                                                     PublishAttachInfo.CompletesQuestion completesQuestion,
                                                     Principal principal) {

        // 找到这个评教卷
        PublishQuestionnaireModel questionnaireModel
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);
        Validator.validateNotNull(questionnaireModel, "评教卷{}不存在", publishId);
        // 获取该评教卷的附加信息
        PublishAttachInfo bean = PublishAttachInfo.getBean(questionnaireModel);
        // 检测该学生是否有权限回答问题
        String loginName = principal.getName();
        AccountModel account = accountService.findUserByAccount(loginName);
        Integer accountId = account.getId();
        Validator.validateTrue(bean.getStudents().contains(accountId), "学生{}不用参与评教任务{}的测评",
                loginName, questionnaireModel.getTeachCourseId());
        // 设置完成了的学生账号
        completesQuestion.setStudentAccountId(accountId);
        // 直接设定为提交
        completesQuestion.setStatus(PublishAttachInfo.CompletesQuestion.STATUS_COMMIT);
        // 填充分数
        fillQuestionScore(questionnaireModel, completesQuestion);
        bean.writeQuestion(completesQuestion);
        questionnaireModel.setStatistics(JSONUtil.toJsonStr(bean));
        // 更新数据入库
        publishQuestionBusinessMapper
                .updateByPrimaryKeySelective(JSON.parseObject(JSON.toJSONString(questionnaireModel),
                        PublishQuestionnaireModel.class));
        return questionnaireModel;
    }

    /**
     * 计算该同学所提交的评教卷的得分情况
     *
     * @param publication
     * @param completesQuestion
     */
    public void fillQuestionScore(PublishQuestionnaireModel publication,
                                  PublishAttachInfo.CompletesQuestion completesQuestion) {
        Integer questionnaireId = publication.getQuestionnaireId();
        EvaluationQuestionnaireModel questionnaireModel
                = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(questionnaireId);
        Map<String, BaseQuestion<ChoseQuestionItem>> evaluationQuestionAnswerMap
                = findEvaluationQuestionAnswerMap(questionnaireModel);
        fillAnswerScore(completesQuestion, evaluationQuestionAnswerMap);
    }

    /**
     * 将评教卷中的问题提取成 问题id 和 问题答案的映射，只包含选择题的
     *
     * @param evaluational 评教卷信息
     * @return
     */
    public Map<String, BaseQuestion<ChoseQuestionItem>> findEvaluationQuestionAnswerMap(EvaluationQuestionnaireModel evaluational) {
        EvaluationQuestionnaireContent contentBean
                = EvaluationQuestionnaireContent.getContentBean(evaluational);
        List<BaseQuestion> questions = contentBean.getQuestions();
        if (CollUtil.isEmpty(questions)) {
            return new HashMap<>(0);
        }
        Map<String, BaseQuestion<ChoseQuestionItem>> questionMap = new HashMap<>(questions.size());
        for (BaseQuestion question : questions) {
            // 如果不是文本题的时候才开始处理
            if (!question.getQuestionnaireType().equals(QuestionnaireEnum.text)) {
                String questionId = question.getId();
                questionMap.put(questionId, JSON.parseObject(JSON.toJSONString(question), new TypeReference<BaseQuestion<ChoseQuestionItem>>() {
                }));
            }
        }
        return questionMap;
    }

    /**
     * 填充用户所回答的问题的分数
     *
     * @param completesQuestion
     * @param evaluationQuestionAnswerMap
     */
    public void fillAnswerScore(PublishAttachInfo.CompletesQuestion completesQuestion,
                                Map<String, BaseQuestion<ChoseQuestionItem>> evaluationQuestionAnswerMap) {

        if (completesQuestion == null) {
            return;
        }
        List<PublishAttachInfo.QuestionReply> questionReplies = completesQuestion.getQuestionReplies();
        if (CollUtil.isEmpty(questionReplies)) {
            return;
        }

        for (PublishAttachInfo.QuestionReply questionReply : questionReplies) {
            QuestionnaireEnum questionnaireEnum = questionReply.getQuestionnaireEnum();
            if (QuestionnaireEnum.text.equals(questionnaireEnum)) {
                continue;
            }
            fillAnswerScore(evaluationQuestionAnswerMap, questionReply);
        }
    }

    /**
     * 给每个答案填充分数
     *
     * @param evaluationQuestionAnswerMap 问题和待回答问题的映射
     * @param questionReply               用户的答案
     */
    public void fillAnswerScore(Map<String, BaseQuestion<ChoseQuestionItem>> evaluationQuestionAnswerMap,
                                PublishAttachInfo.QuestionReply questionReply) {
        String questionId = questionReply.getQuestionId();
        BaseQuestion<ChoseQuestionItem> choseQuestionItemBaseQuestion = evaluationQuestionAnswerMap.get(questionId);
        if (choseQuestionItemBaseQuestion == null) {
            LogUtil.logWarn(log, "问题不存在，却出现在了答案中");
            return;
        }
        Set<String> answerChooseIds = findAnswerChooseIds(questionReply);
        List<ChoseQuestionItem> items = choseQuestionItemBaseQuestion.getItems();
        for (ChoseQuestionItem item : items) {
            String itemId = item.getId();
            for (String answerId : answerChooseIds) {
                if (itemId.equals(answerId)) {
                    // 获取当前选项的分数,并加上现在的分数（为了满足多选题）
                    Integer score = questionReply.getScore();
                    if (score == null) {
                        score = 0;
                    }
                    questionReply.setScore(score + item.getWeights());
                    break;
                }
            }

        }
    }

    /**
     * 获取选项中所有的id
     *
     * @param questionReply
     * @return
     */
    public Set<String> findAnswerChooseIds(PublishAttachInfo.QuestionReply questionReply) {
        String chooseId = questionReply.getChooseId();
        if (chooseId.contains(",")) {
            String[] checkboxs = chooseId.split(",");
            Set<String> ids = new HashSet<>(checkboxs.length);
            ids.addAll(Arrays.asList(checkboxs));
            return ids;
        } else {
            return CollUtil.newHashSet(chooseId);
        }
    }

    /**
     * 批量获取发布评教卷信息
     *
     * @param ids
     * @return
     */
    public List<PublishQuestionnaireModel> batchQuireQuestion(List<Integer> ids) {
        if (CollUtil.isEmpty(ids)) {
            return new ArrayList<>();
        }
        return publishQuestionBusinessMapper.selectByIds(ListUtils.lsitIdsToString(ids));
    }

    /**
     * 发现发布评教卷的详细信息
     *
     * @param ids
     * @return
     */
    public List<PublishQuestionVo> findPublishQuestionDeatil(List<Integer> ids) {
        List<PublishQuestionnaireModel> publishquestionnaires = batchQuireQuestion(ids);
        if (CollUtil.isEmpty(publishquestionnaires)) {
            return new ArrayList<>();
        }
        List<PublishQuestionVo> result = new ArrayList<>(ids.size());
        for (PublishQuestionnaireModel publishquestionnaire : publishquestionnaires) {
            PublishQuestionVo publishQuestionVo = findPublishQuestionVo(publishquestionnaire);
            if (publishQuestionVo == null) {
                continue;
            }
            result.add(publishQuestionVo);
        }
        return result;
    }

    /**
     * 获取发布评教卷的详细信息
     *
     * @param publication 发布的评教卷信息
     * @return 评教卷信息
     */
    public PublishQuestionVo findPublishQuestionVo(PublishQuestionnaireModel publication) {
        Integer teacherAccountId = publication.getTeacherAccountId();
        TeacherModel teacher = teacherBusinessMapper.selectByAccountId(teacherAccountId);
        if (teacher == null) {
            return null;
        }
        teacher.setWorkJson(null);

        // 不显示老师的工作情况
        Integer releaseAccountId = publication.getReleaseAccountId();
        TeacherModel release = teacherBusinessMapper.selectByAccountId(releaseAccountId);
        if (release == null) {
            return null;
        }
        teacher.setWorkJson(null);

        // 找到上课课程
        Integer teachCourseId = publication.getCourseId();
        CourseModel course = courseBusinessMapper.findCourseByTeachCourse(teachCourseId);

        // 生成发布的评教卷信息
        PublishQuestionVo publishQuestionVo = new PublishQuestionVo();
        publishQuestionVo.setTeacher(TeacherVo.teacherToSimpleTeacherVo(teacher));
        publishQuestionVo.setRelease(TeacherVo.teacherToSimpleTeacherVo(release));

        // 获取评教卷的信息
        EvaluationalSimpleVo evaluationalSimpleVo = evaluationquestionnaireService
                .findEvaluationQuestionHaveTeacherInfo(publication.getQuestionnaireId());
        if (evaluationalSimpleVo == null) {
            return null;
        }
        publishQuestionVo.setQuestionnaire(evaluationalSimpleVo);
        publishQuestionVo.setCourse(course);
        publishQuestionVo.setDescription(publication.getDescription());
        publishQuestionVo.setReleaseTime(publication.getReleaseTime());
        publishQuestionVo.setStartRespondTime(publication.getStartRespondTime());
        publishQuestionVo.setEndRespondTime(publication.getEndRespondTime());
        publishQuestionVo.setId(publication.getId());
        String statistics = publication.getStatistics();
        if (statistics != null) {
            publishQuestionVo.setStatistics(JSON.parseObject(statistics));
        }
        return publishQuestionVo;
    }

    /**
     * 老师查阅评教卷信息
     *
     * @param publishQuesting
     * @param principal
     * @return
     */
    public QnaireTask findTeacherQuireTask(Integer publishQuesting, Principal principal) {
        Validator.validateNotNull(publishQuesting, "查询发布评教卷信息时id不能为空");
        String loginName = principal.getName();
        TeacherModel teacherByAccountId = teacherService.findTeacherByAccountLoginName(loginName);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacherByAccountId);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        Validator.validateNotNull(qnaireTask, "用户{}无权限查看评教卷{}", loginName, publishQuesting);
        return qnaireTask;
    }

    /**
     * 老师查阅评教卷信息
     *
     * @param publishQuesting 发布评教卷id
     * @param principal       用户登陆信息
     * @return 发布评教卷信息
     */
    public PublishQuestionnaireModel teacherCheckPendingQuestion(Integer publishQuesting, Principal principal) {
        QnaireTask qnaireTask = findTeacherQuireTask(publishQuesting, principal);
        QnaireTaskItem checkedQnaireTaskItem = qnaireTask.findCheckedQnaireTaskItem(publishQuesting);
        // 如果已经在查阅过的列表中则直接查出评教卷，否则需要将未读移动到已读中
        if (checkedQnaireTaskItem != null) {
            return publishQuestionBusinessMapper.selectByPrimaryKey(publishQuesting);
        }
        String loginName = principal.getName();
        QnaireTaskItem pendingQnaireTaskItem = qnaireTask.findPendingQnaireTaskItem(publishQuesting);
        if (pendingQnaireTaskItem == null) {
            throw new ServiceException(LogUtil.logInfo(log, "在老师{}任务中没有找到发布评教卷{}", loginName, publishQuesting));
        }
        qnaireTask.checkedTask(pendingQnaireTaskItem);

        TeacherModel teacherModel = teacherService.findTeacherByAccountLoginName(loginName);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacherModel);
        teacherWork.setQnaireTask(qnaireTask);
        // 更新老师工作内容
        teacherModel.setWorkJson(JSON.toJSONString(teacherWork));
        teacherBusinessMapper.updateByPrimaryKeySelective(teacherModel);
        return publishQuestionBusinessMapper.selectByPrimaryKey(publishQuesting);
    }

    /**
     * 学生发现评教卷问题
     *
     * @param publishQuesting 发布评教卷id
     * @param principal       用户信息
     * @return
     */
    public QnaireTask findStudentQnaireTask(Integer publishQuesting, Principal principal) {
        if (publishQuesting == null) {
            throw new ServiceException("查询发布评教卷信息时id不能为空");
        }
        if (principal == null) {
            throw new ServiceException("用户未登录");
        }
        String loginName = principal.getName();
        StudentVo studentByAccountName = accountService.findStudentByAccountName(loginName);
        StudentModel student = StudentVo.studentVo2Student(studentByAccountName);
        if (student == null) {
            throw new ServiceException("用户不存在");
        }
        StudentTask studentTask = StudentTask.str2Bean(student);
        QnaireTask qnaireTask = studentTask.getQnaireTask();
        if (qnaireTask == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户{}无权限查看评教卷{}", loginName, publishQuesting));
        }
        return qnaireTask;
    }

    /**
     * 学生查看评教卷信息，若没有点击过则设置点击
     *
     * @param publishQuesting 发布评教卷id
     * @param principal       登陆用户信息
     * @return 发布评教卷信息
     */
    public PublishQuestionnaireModel studentCheckPendingQuestion(Integer publishQuesting, Principal principal) {
        QnaireTask qnaireTask = findStudentQnaireTask(publishQuesting, principal);
        QnaireTaskItem checkedQuireTaskItem = qnaireTask.findCheckedQnaireTaskItem(publishQuesting);
        // 如果已经在查阅过的列表中则直接查出评教卷，否则需要将未读移动到已读中
        if (checkedQuireTaskItem != null) {
            return publishQuestionBusinessMapper.selectByPrimaryKey(publishQuesting);
        }
        String loginName = principal.getName();
        QnaireTaskItem pendingQuireTaskItem = qnaireTask.findPendingQnaireTaskItem(publishQuesting);
        if (pendingQuireTaskItem == null) {
            throw new ServiceException(LogUtil.logInfo(log, "在老师{}任务中没有找到发布评教卷{}", loginName, publishQuesting));
        }
        qnaireTask.checkedTask(pendingQuireTaskItem);

        StudentVo studentByAccountName = accountService.findStudentByAccountName(loginName);
        StudentModel student = StudentVo.studentVo2Student(studentByAccountName);
        Validator.validateNotNull(student, "用户不存在");
        StudentTask studentTask = StudentTask.str2Bean(student);
        studentTask.setQnaireTask(qnaireTask);
        student.setTask(JSON.toJSONString(studentTask));
        studentBusinessMapper.updateByPrimaryKey(student);
        return publishQuestionBusinessMapper.selectByPrimaryKey(publishQuesting);
    }
}
