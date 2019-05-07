package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.json.question.ChoseQuestionItem;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.mapper.*;
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
    private EvaluationquestionnaireMapper evaluationquestionnaireMapper;

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
        if (!id.equals(teacherid)) {
            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
        }

        bean.addBlackStudent(studentIds);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
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
        if (!id.equals(teacherid)) {
            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
        }
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
        fillQuestionScore(publishquestionnaire,completesQuestion);

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
        fillAnswerScore(completesQuestion,evaluationQuestionAnswerMap);
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
                questionMap.put(questionId, JSON.parseObject(JSON.toJSONString(question), new TypeReference<BaseQuestion<ChoseQuestionItem>>(){}));
            }
        }
        return questionMap;
    }

//    public static void main(String[] args) {
//        JSONObject object = JSON.parseObject(getStr());
//
//        EvaluationQuestionnaireContent content = JSON.parseObject(getStr(), EvaluationQuestionnaireContent.class);
//        System.out.println(content);
//    }
//
//    public static String getStr(){
//        return "{\"questions\":[{\"id\":\"35ea2747d1074627885058dc9486a206\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"593e7c5feb85454c906eceeafde2156c\",\"sort\":0,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"c941c74c2bdb4c87848c71baacae6412\",\"sort\":12,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"7efbe86bb6954385b075e9431e348adf\",\"sort\":16,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"00cfdb4ba31b40c7bfeeaff8261964a2\",\"sort\":28,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"text\",\"mustWriter\":true},{\"id\":\"82734a185a564fa7a3fe32b12c77a643\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"2e5e6dbf67664f64bb6586725280caa5\",\"sort\":12,\"weights\":3,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"6461f9d6619e4f41b31ce56f1d9f762d\",\"sort\":19,\"weights\":24,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"df26c22f6f4740f8bbffb21d1087ad56\",\"sort\":24,\"weights\":3,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"5380ec495da3446abe593e5513c4667b\",\"sort\":25,\"weights\":18,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true},{\"id\":\"9d3188a391c74acdbdcc4bbb0d5c6893\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"77d06f779acd407597699d5cc8b4817e\",\"sort\":1,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"c7289e676fa5473fb6523dc0ab58ae5c\",\"sort\":14,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"944e2cb531f44f9892fd67819567041f\",\"sort\":17,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"high\":20,\"width\":20,\"defaultsValue\":\"hello\",\"maxSize\":2000,\"id\":\"132f13d05a7e442eb8d6069c941401c9\",\"sort\":18,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"text\",\"mustWriter\":true},{\"id\":\"59411b5639654803ab6beb4cd32f565e\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"db2452de8d9a4019bb9af21cc7a92a5e\",\"sort\":0,\"weights\":26,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"b27ad398454f45e9a8612035ddab02a1\",\"sort\":4,\"weights\":28,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"6c852fe147a347c8a0720a2c372d7b9b\",\"sort\":15,\"weights\":22,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"25986238b4564fddb1395cfd301954b0\",\"sort\":29,\"weights\":10,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"radio\",\"mustWriter\":true},{\"id\":\"780353fcd3f64272a10239dc3312ed90\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"4ee76c2ca0a14d3a91857e7ceedac015\",\"sort\":10,\"weights\":17,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"68ede14f32324079b575de8a4ceb0184\",\"sort\":18,\"weights\":1,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"fb3865b6a4b44119b67c57d773ef0fce\",\"sort\":18,\"weights\":5,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"8648d3268aea4507a937422e076ffc8d\",\"sort\":19,\"weights\":18,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"radio\",\"mustWriter\":true},{\"id\":\"1e8b7629ff6a4c8aad9bd068b4740900\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"a66acd546b424252af62c903d90f3692\",\"sort\":10,\"weights\":0,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"93d7d09ef75345a789643af05e66956c\",\"sort\":19,\"weights\":0,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"38243cff30aa4d8b82c9bbbc575e3685\",\"sort\":26,\"weights\":6,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"a18cf8276ce0436b9ba445fc9f6cefe7\",\"sort\":27,\"weights\":4,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"radio\",\"mustWriter\":true},{\"id\":\"8c9af30d07e1435e90e9d75cfaf87999\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"16d3fcbb81c746438d60b17092a2bd58\",\"sort\":3,\"weights\":7,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"ea1482930e364fd3849f2f3a7556138d\",\"sort\":14,\"weights\":10,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"910447e8b33d4ee4bd9cb8784d133a1d\",\"sort\":16,\"weights\":23,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"848776e7583f42f6ba1758cfec269f8f\",\"sort\":26,\"weights\":15,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true},{\"id\":\"900c05a71ef44f9cb49e5b8a4dd9b6fd\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"444544792d0245c29b16847ef51829ee\",\"sort\":2,\"weights\":16,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"9630665bcca84fe1b35b91b6dbda0831\",\"sort\":3,\"weights\":7,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"19db557b0575450ebaff4feded18da2d\",\"sort\":10,\"weights\":7,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"662b6ecd93e14be08c4b11e002da6309\",\"sort\":14,\"weights\":17,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true},{\"id\":\"df4999f2c0104553a813b38769524086\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"9029cabc80c84fef9f5f03f5d5d35ed1\",\"sort\":5,\"weights\":19,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"0f2f89ec1c0d4ada94cd368db840a52b\",\"sort\":8,\"weights\":26,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"fc5a0d470374449e807bdc819a9c0732\",\"sort\":26,\"weights\":28,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"80ac1d0ac9a14a6695bc00a1408b7466\",\"sort\":27,\"weights\":19,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true},{\"id\":\"4bc4848b55304593bf0897be8a5ec666\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"7a99767cf29b43ce8c4268851e521a96\",\"sort\":1,\"weights\":18,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"cd1d43d0d5014aa0a6a9bf011897aad2\",\"sort\":9,\"weights\":4,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"6c8f9a1d15314520bdd88937deaf33b3\",\"sort\":15,\"weights\":26,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"46d17aa5342c413399bbb6b8bccf8bbb\",\"sort\":17,\"weights\":4,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true},{\"id\":\"4e5b1dafce314dae92a345592d53b60b\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"85b9796161f1497bb641f6cd9fbd0b17\",\"sort\":0,\"weights\":8,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"7469f69e9d184584a0436247a34295da\",\"sort\":11,\"weights\":26,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"58a98c7b6429466f96dd7229ee2e0ef0\",\"sort\":19,\"weights\":21,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"c17c84ea8cd94077a03708c498ebfe73\",\"sort\":26,\"weights\":17,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true},{\"id\":\"06a0cddd6ea64ab6a402efb61ec54ed6\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"9dad0f25ba6a4da9b43a56701c138fe2\",\"sort\":14,\"weights\":23,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"b02b6e20b0434c2a9c8ff9d19195d09d\",\"sort\":22,\"weights\":7,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"cf51593943ab4c749814164c60c34c6b\",\"sort\":24,\"weights\":24,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"dd2069dc6a904568b7c03d25835e41bb\",\"sort\":25,\"weights\":27,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true},{\"id\":\"26e204b3fe6e4aad848a1aed6cabfcc3\",\"title\":\"测试你的题目\",\"prompt\":\"测试题目\",\"items\":[{\"id\":\"4e956bc79f3541c8a6576f1fc5352c52\",\"sort\":9,\"weights\":9,\"title\":\"选项1\",\"prompt\":\"选项1\",\"mustWriter\":true},{\"id\":\"c9d03ab5835645afad4e8a498e3ceb0d\",\"sort\":18,\"weights\":28,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"90f2669e130a44f697329f164ad92ca5\",\"sort\":22,\"weights\":7,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true},{\"id\":\"8f01ca9856c14b85ab40d201fb3bdaf3\",\"sort\":23,\"weights\":2,\"title\":\"选项2\",\"prompt\":\"选项2\",\"mustWriter\":true}],\"questionnaireType\":\"checkbox\",\"mustWriter\":true}]}";
//    }

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
            if (questionnaireEnum.equals(QuestionnaireEnum.text)){
                continue;
            }
            fillAnswerScore(evaluationQuestionAnswerMap,questionReply);
        }
    }

    /**
     * 给每个答案填充分数
     *
     * @param evaluationQuestionAnswerMap 问题和待回答问题的映射
     * @param questionReply 用户的答案
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
            for (String answerId : answerChooseIds){
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
        Teacher teacher = teacherService.findTeacherByAccountId(teacherid);
        if (teacher == null) {
            return null;
        }
        teacher.setWorkjson(null);

        // 不显示老师的工作情况
        Integer releaseid = publishquestionnaire.getReleaseid();
        Teacher release = teacherService.findTeacherByAccountId(releaseid);
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
        Teacher teacherByAccountId = teacherService.findTeacherByAccountId(loginName);
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
     * @param publishQuesting
     * @param principal
     * @return
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

        Teacher teacherByAccountId = teacherService.findTeacherByAccountId(loginName);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacherByAccountId);
        teacherWork.setQnaireTask(qnaireTask);
        // 更新老师工作内容
        teacherMapper.updateByPrimaryKeySelective(teacherByAccountId);
        return publishquestionnaireMapper.selectByPrimaryKey(publishQuesting);
    }


}
