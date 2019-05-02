//package org.nix.lovedomain.service;
//
//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.json.JSONUtil;
//import com.alibaba.fastjson.JSON;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.nix.lovedomain.EvaluationApplication;
//import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
//import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
//import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
//import org.nix.lovedomain.dao.business.json.task.QnaireTask;
//import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
//import org.nix.lovedomain.model.Account;
//import org.nix.lovedomain.model.Evaluationquestionnaire;
//import org.nix.lovedomain.model.Publishquestionnaire;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.security.Principal;
//import java.util.Date;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//@SpringBootTest(classes = EvaluationApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//public class TeacherServiceTest {
//
//    @Autowired
//    private EvaluationquestionnaireService evaluationquestionnaireService;
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @Autowired
//    public PublishquestionnaireService publishquestionnaireService;
//
//    @Autowired
//    public StudentService studentService;
//
//    @Test
//    public void test100() throws Exception {
//        for (int i = 0; i <50 ; i++) {
//            try {
//                addTask();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    public void addTask() throws Exception {
//        // 创建问卷
//        int teacherId = getTeacherId();
//        Account teacherAccountById = teacherService.findTeacherAccountById(teacherId);
//        Principal principal = teacherAccountById::getNumbering;
//        int roun = (int) (Math.random() * 50);
//        String name = "测试问卷_" + roun;
//        Evaluationquestionnaire simpleQuestion = evaluationquestionnaireService.createSimpleQuestion(name,
//                name, principal);
//        Integer questionId = simpleQuestion.getId();
//        evaluationquestionnaireService.addQuestion(questionId, createQuestion(), principal);
//        evaluationquestionnaireService.addQuestion(questionId, createQuestion(), principal);
//
//        // 发布问卷
//        int shoukeTeacher = getTeacherId();
//        Publishquestionnaire publishquestionnaire = publishquestionnaireService.pusblishQuestionnaire(principal, getCourseId(),
//                shoukeTeacher, questionId, name, new Date().getTime(), new Date().getTime(), 2);
//
//        // 发布任务
//        teacherService.addTask(publishquestionnaire);
//        studentService.addPublishQuestionTask(publishquestionnaire);
//
//        // 查看问卷信息
//        Evaluationquestionnaire evaluationquestionnaireServiceById
//                = evaluationquestionnaireService.findById(questionId);
//        System.err.println(JSONUtil.toJsonStr(evaluationquestionnaireServiceById));
//
//        //查看发布问卷信息
//        Publishquestionnaire publishquestionnaireServiceById
//                = publishquestionnaireService.findById(publishquestionnaire.getId());
//        System.err.println(JSONUtil.toJsonStr(publishquestionnaireServiceById));
//
//
//        // 查看老师任务信息
//        TeacherWork teacherWork = TeacherWork.str2Bean(teacherService.findById(shoukeTeacher));
//        System.err.println(JSONUtil.toJsonStr(teacherWork));
//
//    }
//
//    public int getTeacherId(){
//        return Math.random() > 0.5 ? 2 : 3;
//    }
//
//    public int getCourseId(){
//        return Math.random() > 0.5 ? 1 : 2;
//    }
//
//    public BaseQuestion<BaseItem> createQuestion() {
//        BaseQuestion<BaseItem> question = new BaseQuestion<>();
//        question.setMustWriter(true);
//        question.setQuestionnaireType(QuestionnaireEnum.CHOSE_SINGLE);
//        question.setPrompt("测试题目");
//        question.setTitle("测试你的题目");
//        question.setItems(CollUtil.newArrayList(createItem("选项1"), createItem("选项2")));
//        return question;
//    }
//
//    public BaseItem createItem(String title) {
//        BaseItem one = new BaseItem();
//        one.setMustWriter(true);
//        one.setPrompt(title);
//        one.setSort(1);
//        one.setTitle(title);
//        return one;
//    }
//}