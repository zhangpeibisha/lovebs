package org.nix.lovedomain.service;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.mapper.ClassMapper;
import org.nix.lovedomain.dao.mapper.PublishquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.StatisticsscoreMapper;
import org.nix.lovedomain.dao.mapper.StudentMapper;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.StudentVo;
import org.nix.lovedomain.utils.LogUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Service
@Slf4j
@Transactional
public class PublishquestionnaireService extends BaseService<Publishquestionnaire> {

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private PublishquestionnaireMapper publishquestionnaireMapper;

    @Resource
    private ClassMapper classMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StatisticsscoreMapper statisticsscoreMapper;

    /**
     * 发布问卷
     *
     * @param principal        登陆的用户
     * @param courseId         课程id
     * @param teacherId        老师id
     * @param questionnaireId  问卷id
     * @param description      发布描述
     * @param startRespondTime 开始答卷时间-老师可以在答卷期间编辑黑名单
     * @param endRespondTime   结束答卷时间-任何人禁止修改内容，开始统计数据
     * @return 发布详情
     * @throws Exception 添加信息抛出异常
     */
    public Publishquestionnaire pusblishQuestionnaire(Principal principal,
                                                      Integer courseId,
                                                      Integer teacherId,
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
        publishquestionnaire.setTeacherid(teacherId);

        String name = principal.getName();
        Account userByAccount = accountService.findUserByAccount(name);
        publishquestionnaire.setReleaseid(userByAccount.getId());

        // ==================== 下面开始填充发布问卷的附加信息 ==================

        // 根据课程id和老师id找到相应的学生id
        List<StudentVo> studentByTeacherIdAndCourseId
                = studentBusinessMapper.findStudentByTeacherIdAndCourseId(teacherId, courseId);
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
     * @param publisId
     * @param completesQuestion
     * @return
     */
    public Publishquestionnaire writeQuestion(Integer publisId,
                                              PublishAttachInfo.CompletesQuestion completesQuestion,
                                              Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        checkStudentHavePermissionUse(bean,userByAccount.getId());

        bean.writeQuestion(completesQuestion);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
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

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        checkStudentHavePermissionUse(bean,userByAccount.getId());

        bean.updateQuestion(completesQuestion);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
    }

    /**
     * 批量获取发布问卷信息
     * @param ids
     * @return
     */
    public List<Publishquestionnaire> batchQuireQuestion(List<Integer> ids){
        PublishquestionnaireExample example = new PublishquestionnaireExample();
        example.createCriteria().andIdIn(ids);
        return publishquestionnaireMapper.selectByExample(example);
    }

    public static void checkStudentHavePermissionUse(PublishAttachInfo bean, Integer id) {
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
     * @return List
     */
    public List<Publishquestionnaire> getAllDataByLimit(String dateStr){
           return   publishquestionnaireMapper.getAllDataByLimit(dateStr);
    }

    /**
     * 统计问卷
     * @param publishquestionnaire
     * 维度包含 班级
     * 维度包含 专业
     * 维度包含 学院
     */
    public void statistics(Publishquestionnaire publishquestionnaire){
        // 所有的统统计数据
        List<Statisticsscore> allStatistics = new ArrayList<>();

        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(publishquestionnaire);

        // 获取回答该问卷的所有学生
        List<StudentVo> students = publishAttachInfo.getStudents();

        // 获取该问卷所有的回答
        List<PublishAttachInfo.CompletesQuestion> completesQuestions = publishAttachInfo.getCompletesQuestions();

        if(completesQuestions != null){
            //按班级统计
            statisticsByClass(publishquestionnaire,allStatistics,publishAttachInfo,students,completesQuestions);
            //按专业统计
            statisticsByProfession(publishquestionnaire,allStatistics,publishAttachInfo,students,completesQuestions);
            // 按学院统计
            statisticsByFaculty(publishquestionnaire,allStatistics,publishAttachInfo,students,completesQuestions);
            // 持久化所有的统计结果
            statisticsscoreMapper.Inserts(allStatistics);
        }
    }

    /**
     * 统计问卷
     * @param publishquestionnaire
     * 维度 班级
     */
    public void statisticsByClass(Publishquestionnaire publishquestionnaire,
                                  List<Statisticsscore> allStatistics,
                                  PublishAttachInfo publishAttachInfo,
                                  List<StudentVo> students,
                                  List<PublishAttachInfo.CompletesQuestion> completesQuestions){


        // 按班级存储总分,班级与总分的映射
        HashMap<Integer,Integer> classesScores = new HashMap<>();
        // 学生与班级的映射
        HashMap<Integer,Integer> stuOfClass = new HashMap<>();
        // 每个班级的意见
        HashMap<Integer,List<String>> classesAdvice = new HashMap<>();

        // 初始化映射
        for (StudentVo stu:
             students) {
            classesScores.put(stu.getClasszz().getId(),0);
            classesAdvice.put(stu.getClasszz().getId(),new ArrayList<>());
            stuOfClass.put(stu.getId(),stu.getClasszz().getId());
        }

        /*扫描各个回答并记分*/
        for (PublishAttachInfo.CompletesQuestion completesQuestion:
                completesQuestions) {

            if(publishAttachInfo.getBlack().contains(completesQuestion.getStudentId())){
                continue;
            }
            for (PublishAttachInfo.QuestionReply questionReply:
                 completesQuestion.getQuestionReplies()) {
                 /*收集意见*/
                 if(questionReply.getSuggest() != null && !questionReply.getSuggest().equals("")){
                     List<String>  tempList =  classesAdvice.get(completesQuestion.getStudentId());
                     tempList.add(questionReply.getSuggest());
                     classesAdvice.put(completesQuestion.getStudentId(),tempList);
                 }
                Integer score = questionReply.getScore();
                //不计入总分的情况：1）分数字段为空，2）分数小于0,3）该学生被列入黑名单
                if (score == null || score <= 0) {
                    continue;
                }
                classesScores.put(stuOfClass.get(completesQuestion.getStudentId()),
                        classesScores.get(completesQuestion.getStudentId())+score);
            }
        }

        for (Integer key:
        classesScores.keySet()) {
            Statisticsscore statisticsscore = new Statisticsscore();
            statisticsscore.setClassid(key);
            statisticsscore.setPublishquestionnaireid(publishquestionnaire.getId());
            statisticsscore.setTeacherid(publishquestionnaire.getTeacherid());
            statisticsscore.setFraction(classesScores.get(key));
            PublishAttachInfo publishAttachInfo1 = new PublishAttachInfo();
            publishAttachInfo1.setScore(classesScores.get(key));
            publishAttachInfo1.setAdvice(classesAdvice.get(key));
            statisticsscore.setAttachjson(JSONUtil.toJsonStr(publishAttachInfo1));
            allStatistics.add(statisticsscore);
        }

    }

    /**
     * 按专业统计
     * @param publishquestionnaire
     * @param allStatistics
     */
    public void statisticsByProfession(Publishquestionnaire publishquestionnaire,
                                       List<Statisticsscore> allStatistics,
                                       PublishAttachInfo publishAttachInfo,
                                       List<StudentVo> students,
                                       List<PublishAttachInfo.CompletesQuestion> completesQuestions){
        // 获取所有学生的专业,学生与专业的映射
        HashMap<Integer,Integer> stuOfProssions = studentMapper.selectAllStuOfProfession();

        // 按专业存储总分,班级与总分的映射
        HashMap<Integer,Integer> professionScores = new HashMap<>();

        // 每个班级的意见
        HashMap<Integer,List<String>> professionAdvice = new HashMap<>();

        // 初始化映射
        for (StudentVo stu:
                students) {
            professionScores.put(stuOfProssions.get(stu.getId()),0);
            professionAdvice.put(stu.getClasszz().getId(),new ArrayList<>());
        }

        /*扫描各个回答并记分*/
        for (PublishAttachInfo.CompletesQuestion completesQuestion:
                completesQuestions) {

            if(publishAttachInfo.getBlack().contains(completesQuestion.getStudentId())){
                continue;
            }
            for (PublishAttachInfo.QuestionReply questionReply:
                    completesQuestion.getQuestionReplies()) {
                /*收集意见*/
                if(questionReply.getSuggest() != null && !questionReply.getSuggest().equals("")){
                    List<String>  tempList =  professionAdvice.get(completesQuestion.getStudentId());
                    tempList.add(questionReply.getSuggest());
                    professionAdvice.put(completesQuestion.getStudentId(),tempList);
                }
                Integer score = questionReply.getScore();
                //不计入总分的情况：1）分数字段为空，2）分数小于0,3）该学生被列入黑名单
                if (score == null || score <= 0) {
                    continue;
                }
                professionScores.put(stuOfProssions.get(completesQuestion.getStudentId()),
                        professionScores.get(completesQuestion.getStudentId())+score);
            }
        }

        for (Integer key:
                professionScores.keySet()) {
            Statisticsscore statisticsscore = new Statisticsscore();
            statisticsscore.setProfessionid(key);
            statisticsscore.setPublishquestionnaireid(publishquestionnaire.getId());
            statisticsscore.setTeacherid(publishquestionnaire.getTeacherid());
            statisticsscore.setFraction(professionScores.get(key));
            PublishAttachInfo publishAttachInfo1 = new PublishAttachInfo();
            publishAttachInfo1.setScore(professionScores.get(key));
            publishAttachInfo1.setAdvice(professionAdvice.get(key));
            statisticsscore.setAttachjson(JSONUtil.toJsonStr(publishAttachInfo1));
            allStatistics.add(statisticsscore);
        }



    }

    /**
     * 按学院统计
     * @param publishquestionnaire
     * @param allStatistics
     */
    public void statisticsByFaculty(Publishquestionnaire publishquestionnaire,
                                    List<Statisticsscore> allStatistics,
                                    PublishAttachInfo publishAttachInfo,
                                    List<StudentVo> students,
                                    List<PublishAttachInfo.CompletesQuestion> completesQuestions){

        // 获取所有学生的专业,学生与学院的映射
        HashMap<Integer,Integer> stuOfFaculty = studentMapper.selectAllStuOfFaculty();

        // 按专业存储总分,班级与总分的映射
        HashMap<Integer,Integer> facultyScores = new HashMap<>();

        // 每个班级的意见
        HashMap<Integer,List<String>> facultyAdvice = new HashMap<>();

        // 初始化映射
        for (StudentVo stu:
                students) {
            facultyScores.put(stuOfFaculty.get(stu.getId()),0);
            facultyAdvice.put(stu.getClasszz().getId(),new ArrayList<>());
        }

        /*扫描各个回答并记分*/
        for (PublishAttachInfo.CompletesQuestion completesQuestion:
                completesQuestions) {

            if(publishAttachInfo.getBlack().contains(completesQuestion.getStudentId())){
                continue;
            }
            for (PublishAttachInfo.QuestionReply questionReply:
                    completesQuestion.getQuestionReplies()) {
                /*收集意见*/
                if(questionReply.getSuggest() != null && !questionReply.getSuggest().equals("")){
                    List<String>  tempList =  facultyAdvice.get(completesQuestion.getStudentId());
                    tempList.add(questionReply.getSuggest());
                    facultyAdvice.put(completesQuestion.getStudentId(),tempList);
                }
                Integer score = questionReply.getScore();
                //不计入总分的情况：1）分数字段为空，2）分数小于0,3）该学生被列入黑名单
                if (score == null || score <= 0) {
                    continue;
                }
                facultyScores.put(stuOfFaculty.get(completesQuestion.getStudentId()),
                        facultyScores.get(completesQuestion.getStudentId())+score);
            }
        }

        for (Integer key:
                facultyScores.keySet()) {
            Statisticsscore statisticsscore = new Statisticsscore();
            statisticsscore.setFacultyid(key);
            statisticsscore.setPublishquestionnaireid(publishquestionnaire.getId());
            statisticsscore.setTeacherid(publishquestionnaire.getTeacherid());
            statisticsscore.setFraction(facultyScores.get(key));
            PublishAttachInfo publishAttachInfo1 = new PublishAttachInfo();
            publishAttachInfo1.setScore(facultyScores.get(key));
            publishAttachInfo1.setAdvice(facultyAdvice.get(key));
            statisticsscore.setAttachjson(JSONUtil.toJsonStr(publishAttachInfo1));
            allStatistics.add(statisticsscore);
        }
    }




}
