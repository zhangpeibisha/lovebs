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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private StudentBusinessMapper studentBusinessMapper1;

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
     * 发布评教卷
     *
     * @param principal        登陆的用户
     * @param teachCourseId    teacher_course自增主键
     * @param teacherAccountId 老师id
     * @param questionnaireId  评教卷id
     * @param description      发布描述
     * @param startRespondTime 开始答卷时间-老师可以在答卷期间编辑黑名单
     * @param endRespondTime   结束答卷时间-任何人禁止修改内容，开始统计数据
     * @return 发布详情
     */
    public PublishQuestionnaireModel pusblishQuestionnaire(Principal principal,
                                                           Integer teachCourseId,
                                                           Integer teacherAccountId,
                                                           Integer questionnaireId,
                                                           String description,
                                                           Long startRespondTime,
                                                           Long endRespondTime,
                                                           Integer balcks) {

        PublishQuestionnaireModel publication = new PublishQuestionnaireModel();
        publication.setCourseId(teachCourseId);
        publication.setDescription(description);

        publication.setEndRespondTime(new Date(endRespondTime));
        publication.setStartRespondTime(new Date(startRespondTime));
        publication.setQuestionnaireId(questionnaireId);

        // 授课老师的账号id
        publication.setTeacherId(teacherAccountId);

        // 获取发布人的账号id
        String loginName = principal.getName();
        AccountModel userByAccount = accountService.findUserByAccount(loginName);
        publication.setReleaseId(userByAccount.getId());

        // ==================== 下面开始填充发布评教卷的附加信息 ==================

        // 根据课程id和老师账号id找到相应的学生id
        List<StudentVo> studentByTeacherIdAndCourseId
                = studentBusinessMapper.findStudentByTeacherIdAndCourseId(teacherAccountId,
                teachCourseId);

        int size = studentByTeacherIdAndCourseId.size();
        PublishAttachInfo publishAttachInfo = new PublishAttachInfo();
        publishAttachInfo.setPlan(size);
        publishAttachInfo.setStudents(studentByTeacherIdAndCourseId);
        publishAttachInfo.setCanFilters(balcks);


        // 设置统计信息
        publication.setStatistics(JSONUtil.toJsonStr(publishAttachInfo));

        // 执行保存动作
        publishQuestionBusinessMapper.insertSelective(publication);
        return publication;
    }

    /**
     * 添加黑名单学生
     *
     * @param publishId  发布id
     * @param studentIds 学生账户id集合
     * @return 处理后的数据
     */
    public PublishQuestionnaireModel addBlack(Integer publishId,
                                              List<Integer> studentIds,
                                              Principal principal) {
        PublishQuestionnaireModel questionnaireModel
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);
        Validator.validateNotNull(questionnaireModel, "评教卷{}不存在", publishId);
        checkPermission(questionnaireModel, principal);

        PublishAttachInfo bean = PublishAttachInfo.getBean(questionnaireModel);
        bean.addBlackStudent(studentIds);
        questionnaireModel.setStatistics(JSONUtil.toJsonStr(bean));
        publishQuestionBusinessMapper.updateByPrimaryKeySelective(questionnaireModel);
        return PublishQuestionJsonVo.publishquestionnaire2Vo(questionnaireModel);
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
        Validator.validateTrue(teacherAccountId.equals(questionnaireModel.getTeacherId()),
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
        PublishQuestionnaireModel questionnaireModel
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);
        Validator.validateNotNull(questionnaireModel, "评教卷{}不存在", publishId);

        PublishAttachInfo bean = PublishAttachInfo.getBean(questionnaireModel);

        // 检测该学生是否有权限回答问题


        StudentVo studentByAccountName = accountService.findStudentByAccountName(principal.getName());
        if (studentByAccountName == null) {
            throw new ServiceException(LogUtil.logWarn(log, "用户未登陆答卷"));
        }
        Integer id = studentByAccountName.getId();
        completesQuestion.setStudentId(id);
        // 直接设定为提交
        completesQuestion.setStatus(PublishAttachInfo.CompletesQuestion.STATUS_COMMIT);
        // 填充分数
        fillQuestionScore(questionnaireModel, completesQuestion);

        bean.writeQuestion(completesQuestion);
        questionnaireModel.setStatistics(JSONUtil.toJsonStr(bean));

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
        String content = evaluational.getContent();
        System.out.println(content);
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
            if (questionnaireEnum.equals(QuestionnaireEnum.text)) {
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
        Integer teacherAccountId = publication.getTeacherId();
        TeacherModel teacher = teacherBusinessMapper.selectByAccountId(teacherAccountId);
        if (teacher == null) {
            return null;
        }
        teacher.setWorkJson(null);

        // 不显示老师的工作情况
        Integer releaseAccountId = publication.getReleaseId();
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
        studentBusinessMapper1.updateByPrimaryKey(student);
        return publishQuestionBusinessMapper.selectByPrimaryKey(publishQuesting);
    }


    /**
     * 通过评教卷id获取评教卷的统计信息
     *
     * @param publishId
     * @return
     */
    public PublishAttachInfo.StatisticalAnswer getQuestionStatisticalScore(Integer publishId) {
        PublishQuestionnaireModel publishQuestionnaireModel
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(publishQuestionnaireModel);

        /*将评教卷平均成绩持久化到数据库*/
        StatisticsScoreModel statistics = new StatisticsScoreModel();
        statistics.setPublishQuestionnaireId(publishId);
        statistics.setFraction(bean.getScore());
        statistics.setTeacherId(publishQuestionnaireModel.getTeacherId());
        statistics.setCourseId(publishQuestionnaireModel.getCourseId());
        statisticsScoreBusinessMapper.insertSelective(statistics);
        return bean.statisticalAnswer();
    }


    /**
     * 根据专业id获取专业为维度的评教卷统计
     *
     * @param professionId
     * @return
     */
    public Map<String, Object> professionScoreStatistics(Integer professionId) {
        Map<String, Object> resultMap = new HashMap<>();
        StatisticsScoreModel statistic;

        // 获取该专业下所有评教卷统计结果
        StatisticsScoreModel statisticsScoreModel = new StatisticsScoreModel();
        statisticsScoreModel.setProfessionId(professionId);
        List<StatisticsScoreModel> statistics
                = statisticsScoreBusinessMapper.select(statisticsScoreModel);
        // 该专业下已经发布过多少评教卷


        return null;

    }

    /**
     * 按学院维度进行统计
     *
     * @param factoryId
     * @return
     */
    public Map<String, Object> factoryScoreStatistics(Integer factoryId) {
        return null;
    }

    /**
     * 1)计算每张评教卷的平均分数
     * 2)计算所有评教卷的总分
     * 3)收集所有的意见
     *
     * @return
     */
    private StatisticsScoreModel statisticsExcute(List<StatisticsScoreModel> statistics) {
        StatisticsScoreModel statisticsscore = new StatisticsScoreModel();
        int size = statistics.size();
        // 总分
        int total = 0;
        // 所有的意见
        List<String> advices = new ArrayList<>();
        for (StatisticsScoreModel s :
                statistics) {
            /*收集意见*/
            // 单个评教卷的所有问题


            /*计算总分*/
            Integer score = s.getFraction();
            if (score != null && score != 0) {
                total += score;
            }
        }
        return statisticsscore;
    }
}
