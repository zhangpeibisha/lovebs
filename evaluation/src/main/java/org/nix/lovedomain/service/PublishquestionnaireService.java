package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.json.question.ChoseQuestionItem;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.business.json.student.StudentTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.mapper.*;
import org.nix.lovedomain.dao.model.PublishquestionnaireModel;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.*;
import org.nix.lovedomain.utils.LogUtil;
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
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PublishquestionnaireService extends BaseService<Publishquestionnaire> {

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private PublishquestionnaireMapper publishquestionnaireMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    @Autowired
    private TeacherService teacherService;

    @Resource
    private EvaluationquestionnaireService evaluationquestionnaireService;

    /**
     * 发布问卷
     *
     * @param principal        登陆的用户
     * @param courseId         课程id
     * @param teacherAccountId 老师id
     * @param questionnaireId  问卷id
     * @param description      发布描述
     * @param startRespondTime 开始答卷时间-老师可以在答卷期间编辑黑名单
     * @param endRespondTime   结束答卷时间-任何人禁止修改内容，开始统计数据
     * @return 发布详情
     * @throws Exception 添加信息抛出异常
     */
    public Publishquestionnaire pusblishQuestionnaire(Principal principal,
                                                      Integer courseId,
                                                      Integer teacherAccountId,
                                                      Integer questionnaireId,
                                                      String description,
                                                      Long startRespondTime,
                                                      Long endRespondTime,
                                                      Integer balcks) throws Exception {

        Publishquestionnaire publishquestionnaire = new Publishquestionnaire();
        publishquestionnaire.setCourseid(courseId);
        publishquestionnaire.setDescription(description);
        publishquestionnaire.setEndrespondtime(new Date(endRespondTime));
        publishquestionnaire.setStartrespondtime(new Date(startRespondTime));
        publishquestionnaire.setQuestionnaireid(questionnaireId);
        // 授课老师的账号id
        publishquestionnaire.setTeacherid(teacherAccountId);

        // 获取发布人的账号id
        String name = principal.getName();
        Account userByAccount = accountService.findUserByAccount(name);
        publishquestionnaire.setReleaseid(userByAccount.getId());

        // ==================== 下面开始填充发布问卷的附加信息 ==================

        // 根据课程id和老师id找到相应的学生id
        List<StudentVo> studentByTeacherIdAndCourseId
                = studentBusinessMapper.findStudentByTeacherIdAndCourseId(teacherAccountId, courseId);

        int size = studentByTeacherIdAndCourseId.size();
        PublishAttachInfo publishAttachInfo = new PublishAttachInfo();
        publishAttachInfo.setPlan(size);
        publishAttachInfo.setStudents(studentByTeacherIdAndCourseId);
        publishAttachInfo.setCanFilters(balcks);


        // 设置统计信息
        publishquestionnaire.setStatistics(JSONUtil.toJsonStr(publishAttachInfo));

        // 执行保存动作
        publishquestionnaireMapper.insertSelective(publishquestionnaire);
        return publishquestionnaire;
    }

    /**
     * 添加黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    public Publishquestionnaire addBlack(Integer publisId,
                                         List<Integer> studentIds,
                                         Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        Integer id = userByAccount.getId();
        Integer teacherid = byId.getTeacherid();
//        if (!id.equals(teacherid)) {
//            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
//        }

        bean.addBlackStudent(studentIds);
        byId.setStatistics(JSONUtil.toJsonStr(bean));

        PublishquestionnaireModel publishquestionnaireModel
                = PublishquestionnaireModel.publishquestionnaire2Model(byId);

        publishQuestionBusinessMapper.updateByPrimaryKeySelective(publishquestionnaireModel);
        return PublishQuestionJsonVo.publishquestionnaire2Vo(byId);
    }

    /**
     * 删除黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    public Publishquestionnaire deleteBlack(Integer publisId,
                                            List<Integer> studentIds,
                                            Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        Integer id = userByAccount.getId();
        Integer teacherid = byId.getTeacherid();
//        if (!id.equals(teacherid)) {
//            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
//        }
        bean.deleteBlackStudent(studentIds);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
    }

    /**
     * 提交回答信息，
     *
     * @param publishId
     * @param completesQuestion
     * @return
     */
    public Publishquestionnaire writeQuestion(Integer publishId,
                                              PublishAttachInfo.CompletesQuestion completesQuestion,
                                              Principal principal) {
        Publishquestionnaire publishquestionnaire = findById(publishId);
        if (publishquestionnaire == null) {
            throw new ServiceException(LogUtil.logInfo(log, "发布问卷{}不存在", publishId));
        }

        PublishAttachInfo bean = PublishAttachInfo.getBean(publishquestionnaire);

        // 检测该学生是否有权限回答问题
//        checkStudentHavePermissionUse(bean, findStudentInStudentTableIdByAccount(principal));

        StudentVo studentByAccountName = accountService.findStudentByAccountName(principal.getName());
        if (studentByAccountName == null) {
            throw new ServiceException(LogUtil.logWarn(log, "用户未登陆答卷"));
        }
        Integer id = studentByAccountName.getId();
        completesQuestion.setStudentId(id);
        // 直接设定为提交
        completesQuestion.setStatus(PublishAttachInfo.CompletesQuestion.STATUS_COMMIT);
        // 填充分数
        fillQuestionScore(publishquestionnaire, completesQuestion);

        bean.writeQuestion(completesQuestion);
        publishquestionnaire.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(publishquestionnaire);
        return publishquestionnaire;
    }

    /**
     * 计算该同学所提交的问卷的得分情况
     *
     * @param publishquestionnaire
     * @param completesQuestion
     */
    public void fillQuestionScore(Publishquestionnaire publishquestionnaire,
                                  PublishAttachInfo.CompletesQuestion completesQuestion) {
        Integer questionnaireid = publishquestionnaire.getQuestionnaireid();
        Evaluationquestionnaire evaluationquestionnaire
                = evaluationquestionnaireService.findById(questionnaireid);
        Map<String, BaseQuestion<ChoseQuestionItem>> evaluationQuestionAnswerMap
                = findEvaluationQuestionAnswerMap(evaluationquestionnaire);
        fillAnswerScore(completesQuestion, evaluationQuestionAnswerMap);
    }

    /**
     * 将问卷中的问题提取成 问题id 和 问题答案的映射，只包含选择题的
     *
     * @param evaluationquestionnaire 问卷信息
     * @return
     */
    public Map<String, BaseQuestion<ChoseQuestionItem>> findEvaluationQuestionAnswerMap(Evaluationquestionnaire evaluationquestionnaire) {
        String content = evaluationquestionnaire.getContent();
        System.out.println(content);
        EvaluationQuestionnaireContent contentBean
                = EvaluationQuestionnaireContent.getContentBean(evaluationquestionnaire);
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
     * 通过学生账号信息获取学生信息
     *
     * @param principal 登陆用户信息
     * @return
     */
    public Integer findStudentInStudentTableIdByAccount(Principal principal) {
        if (principal == null) {
            return null;
        }
        Account userByAccount = accountService.findUserByAccount(principal.getName());
        if (userByAccount == null) {
            return null;
        }
        StudentExample studentExample = new StudentExample();
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (CollUtil.isEmpty(students) || students.size() != 1) {
            return null;
        }
        return students.get(0).getId();
    }

    /**
     * 更新回答，只有 status=keep的时候可以更新
     *
     * @param publisId
     * @param completesQuestion
     * @return
     */
    public Publishquestionnaire updateQuestion(Integer publisId,
                                               PublishAttachInfo.CompletesQuestion completesQuestion,
                                               Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        // 检测学生是否有权限更新问题
        checkStudentHavePermissionUse(bean, findStudentInStudentTableIdByAccount(principal));

        bean.updateQuestion(completesQuestion);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
    }

    /**
     * 批量获取发布问卷信息
     *
     * @param ids
     * @return
     */
    public List<Publishquestionnaire> batchQuireQuestion(List<Integer> ids) {
        if (CollUtil.isEmpty(ids)) {
            return new ArrayList<>();
        }
        PublishquestionnaireExample example = new PublishquestionnaireExample();
        example.createCriteria().andIdIn(ids);
        return publishquestionnaireMapper.selectByExample(example);
    }

    /**
     * 发现发布问卷的详细信息
     *
     * @param ids
     * @return
     */
    public List<PublishQuestionVo> findPublishQuestionDeatil(List<Integer> ids) {
        List<Publishquestionnaire> publishquestionnaires = batchQuireQuestion(ids);
        if (CollUtil.isEmpty(publishquestionnaires)) {
            return new ArrayList<>();
        }
        List<PublishQuestionVo> result = new ArrayList<>(ids.size());
        for (Publishquestionnaire publishquestionnaire : publishquestionnaires) {
            PublishQuestionVo publishQuestionVo = findPublishQuestionVo(publishquestionnaire);
            if (publishQuestionVo == null) {
                continue;
            }
            result.add(publishQuestionVo);
        }
        return result;
    }

    /**
     * 获取发布问卷的详细信息
     *
     * @param publishquestionnaire
     * @return
     */
    public PublishQuestionVo findPublishQuestionVo(Publishquestionnaire publishquestionnaire) {
        Integer teacherid = publishquestionnaire.getTeacherid();
        Teacher teacher = teacherService.findTeacherByAccountLoginName(teacherid);
        if (teacher == null) {
            return null;
        }
        teacher.setWorkjson(null);

        // 不显示老师的工作情况
        Integer releaseid = publishquestionnaire.getReleaseid();
        Teacher release = teacherService.findTeacherByAccountLoginName(releaseid);
        if (release == null) {
            return null;
        }
        release.setWorkjson(null);


        Integer courseid = publishquestionnaire.getCourseid();
        Course course = courseMapper.selectByPrimaryKey(courseid);

        PublishQuestionVo publishQuestionVo = new PublishQuestionVo();
        publishQuestionVo.setTeacher(TeacherVo.teacherToSimpleTeacherVo(teacher));
        publishQuestionVo.setRelease(TeacherVo.teacherToSimpleTeacherVo(release));
        EvaluationquestionnaireSimpleVo evaluationquestionnaireSimpleVo = evaluationquestionnaireService
                .findSimpleVoById(publishquestionnaire.getQuestionnaireid());
        if (evaluationquestionnaireSimpleVo == null) {
            return null;
        }
        publishQuestionVo.setQuestionnaire(evaluationquestionnaireSimpleVo);
        publishQuestionVo.setCourse(course);
        publishQuestionVo.setDescription(publishquestionnaire.getDescription());
        publishQuestionVo.setReleaseTime(publishquestionnaire.getReleasetime());
        publishQuestionVo.setStartRespondTime(publishquestionnaire.getStartrespondtime());
        publishQuestionVo.setEndRespondTime(publishquestionnaire.getEndrespondtime());
        publishQuestionVo.setId(publishquestionnaire.getId());
        String statistics = publishquestionnaire.getStatistics();
        if (statistics != null) {
            publishQuestionVo.setStatistics(JSON.parseObject(statistics));
        }
        return publishQuestionVo;
    }

    /**
     * @param bean 发布问卷统计实体
     * @param id   学生在学生表中的主键id
     */
    public static void checkStudentHavePermissionUse(PublishAttachInfo bean, Integer id) {
        if (bean == null || id == null) {
            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
        }
        List<StudentVo> students = bean.getStudents();
        boolean flag = false;
        for (StudentVo studentVo : students) {
            if (studentVo.getId().equals(id)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
        }
    }

    /**
     * 获取需要发布的所有问卷
     *
     * @return List
     */
    public List<Publishquestionnaire> getAllDataByLimit(String dateStr) {
        return publishquestionnaireMapper.getAllDataByLimit(dateStr);
    }

    /**
     * 老师查阅问卷信息
     *
     * @param publishQuesting
     * @param principal
     * @return
     */
    public QnaireTask findTeacherQnaireTask(Integer publishQuesting, Principal principal) {
        if (publishQuesting == null) {
            throw new ServiceException("查询发布问卷信息时id不能为空");
        }
        if (principal == null) {
            throw new ServiceException("用户未登录");
        }
        String loginName = principal.getName();
        Teacher teacherByAccountId = teacherService.findTeacherByAccountLoginName(loginName);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacherByAccountId);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        if (qnaireTask == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户{}无权限查看问卷{}", loginName, publishQuesting));
        }
        return qnaireTask;
    }

    /**
     * 老师查阅问卷信息
     *
     * @param publishQuesting 发布问卷id
     * @param principal       用户登陆信息
     * @return 发布问卷信息
     */
    public Publishquestionnaire teacherCheckPendingQuestion(Integer publishQuesting, Principal principal) {
        QnaireTask qnaireTask = findTeacherQnaireTask(publishQuesting, principal);
        QnaireTaskItem checkedQnaireTaskItem = qnaireTask.findCheckedQnaireTaskItem(publishQuesting);
        // 如果已经在查阅过的列表中则直接查出问卷，否则需要将未读移动到已读中
        if (checkedQnaireTaskItem != null) {
            return publishquestionnaireMapper.selectByPrimaryKey(publishQuesting);
        }
        String loginName = principal.getName();
        QnaireTaskItem pendingQnaireTaskItem = qnaireTask.findPendingQnaireTaskItem(publishQuesting);
        if (pendingQnaireTaskItem == null) {
            throw new ServiceException(LogUtil.logInfo(log, "在老师{}任务中没有找到发布问卷{}", loginName, publishQuesting));
        }
        qnaireTask.checkedTask(pendingQnaireTaskItem);

        Teacher teacherByAccountId = teacherService.findTeacherByAccountLoginName(loginName);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacherByAccountId);
        teacherWork.setQnaireTask(qnaireTask);
        // 更新老师工作内容
        teacherByAccountId.setWorkjson(JSON.toJSONString(teacherWork));
        teacherMapper.updateByPrimaryKeySelective(teacherByAccountId);
        return publishquestionnaireMapper.selectByPrimaryKey(publishQuesting);
    }

    /**
     * 学生发现问卷问题
     *
     * @param publishQuesting 发布问卷id
     * @param principal       用户信息
     * @return
     */
    public QnaireTask findStudentQnaireTask(Integer publishQuesting, Principal principal) {
        if (publishQuesting == null) {
            throw new ServiceException("查询发布问卷信息时id不能为空");
        }
        if (principal == null) {
            throw new ServiceException("用户未登录");
        }
        String loginName = principal.getName();
        StudentVo studentByAccountName = accountService.findStudentByAccountName(loginName);
        Student student = StudentVo.studentVo2Student(studentByAccountName);
        if (student == null) {
            throw new ServiceException("用户不存在");
        }
        StudentTask studentTask = StudentTask.str2Bean(student);
        QnaireTask qnaireTask = studentTask.getQnaireTask();
        if (qnaireTask == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户{}无权限查看问卷{}", loginName, publishQuesting));
        }
        return qnaireTask;
    }

    /**
     * 学生查看问卷信息，若没有点击过则设置点击
     *
     * @param publishQuesting 发布问卷id
     * @param principal       登陆用户信息
     * @return 发布问卷信息
     */
    public Publishquestionnaire studentCheckPendingQuestion(Integer publishQuesting, Principal principal) {
        QnaireTask qnaireTask = findStudentQnaireTask(publishQuesting, principal);
        QnaireTaskItem checkedQnaireTaskItem = qnaireTask.findCheckedQnaireTaskItem(publishQuesting);
        // 如果已经在查阅过的列表中则直接查出问卷，否则需要将未读移动到已读中
        if (checkedQnaireTaskItem != null) {
            return publishquestionnaireMapper.selectByPrimaryKey(publishQuesting);
        }
        String loginName = principal.getName();
        QnaireTaskItem pendingQnaireTaskItem = qnaireTask.findPendingQnaireTaskItem(publishQuesting);
        if (pendingQnaireTaskItem == null) {
            throw new ServiceException(LogUtil.logInfo(log, "在老师{}任务中没有找到发布问卷{}", loginName, publishQuesting));
        }
        qnaireTask.checkedTask(pendingQnaireTaskItem);

        StudentVo studentByAccountName = accountService.findStudentByAccountName(loginName);
        Student student = StudentVo.studentVo2Student(studentByAccountName);
        if (student == null) {
            throw new ServiceException("用户不存在");
        }
        StudentTask studentTask = StudentTask.str2Bean(student);
        studentTask.setQnaireTask(qnaireTask);
        student.setTask(JSON.toJSONString(studentTask));
        studentMapper.updateByPrimaryKey(student);
        return publishquestionnaireMapper.selectByPrimaryKey(publishQuesting);
    }

}
