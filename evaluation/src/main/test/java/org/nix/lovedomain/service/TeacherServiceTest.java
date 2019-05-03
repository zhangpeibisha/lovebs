package java.org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.json.question.ChoseQuestionItem;
import org.nix.lovedomain.dao.business.json.question.FillBlankQuestionItem;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.dao.business.json.question.base.BaseItem;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.Evaluationquestionnaire;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.service.EvaluationquestionnaireService;
import org.nix.lovedomain.service.PublishquestionnaireService;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest(classes = EvaluationApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TeacherServiceTest {

    @Autowired
    private EvaluationquestionnaireService evaluationquestionnaireService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    public PublishquestionnaireService publishquestionnaireService;

    @Autowired
    public StudentService studentService;

    @Resource
    private AccountMapper accountMapper;

    @Test
    public void test100() throws Exception {
        for (int i = 0; i < 50; i++) {
            try {
                addTask();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void addTask() throws Exception {
        // 创建问卷
        int teacherAccountId = getTeacherId();
        Account teacherAccountById = accountMapper.selectByPrimaryKey(teacherAccountId);
        Principal principal = teacherAccountById::getNumbering;
        int roun = (int) (Math.random() * 50);
        String name = "测试问卷_" + roun;
        Evaluationquestionnaire simpleQuestion = evaluationquestionnaireService.createSimpleQuestion(name,
                name, principal);
        Integer questionId = simpleQuestion.getId();

        // 给问卷批量添加问题
        evaluationquestionnaireService.addQuestion(questionId, createQuestionList((int) (Math.random() * 30)), principal);

        // 发布问卷
        int shoukeTeacher = getTeacherId();
        Publishquestionnaire publishquestionnaire = publishquestionnaireService.pusblishQuestionnaire(principal, getCourseId(),
                shoukeTeacher, questionId, name, new Date().getTime(), new Date().getTime(), 2);

        // 发布任务
        teacherService.addTask(publishquestionnaire);
        studentService.addPublishQuestionTask(publishquestionnaire);

        // 查看问卷信息
        Evaluationquestionnaire evaluationquestionnaireServiceById
                = evaluationquestionnaireService.findById(questionId);
        System.err.println(JSONUtil.toJsonStr(evaluationquestionnaireServiceById));

        //查看发布问卷信息
        Publishquestionnaire publishquestionnaireServiceById
                = publishquestionnaireService.findById(publishquestionnaire.getId());
        System.err.println(JSONUtil.toJsonStr(publishquestionnaireServiceById));


        // 查看老师任务信息
        TeacherWork teacherWork = TeacherWork.str2Bean(teacherService.findById(shoukeTeacher));
        System.err.println(JSONUtil.toJsonStr(teacherWork));

    }

    public int getTeacherId() {
        return Math.random() > 0.5 ? 20 : 10;
    }

    public int getCourseId() {
        return Math.random() > 0.5 ? 1 : 2;
    }

    public List<BaseQuestion> createQuestionList(int size) {
        List<BaseQuestion> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(createQuestion());
        }
        return result;
    }

    public BaseQuestion<BaseItem> createQuestion() {
        BaseQuestion<BaseItem> question = new BaseQuestion<>();
        question.setMustWriter(true);
        QuestionnaireEnum type = getType();
        question.setQuestionnaireType(type);
        question.setPrompt("测试题目");
        question.setTitle("测试你的题目");
        if (type.equals(QuestionnaireEnum.radio) || type.equals(QuestionnaireEnum.checkbox)) {
            question.setItems(CollUtil.newArrayList(createChooseItem("选项1"),
                    createChooseItem("选项2"),
                    createChooseItem("选项2"),
                    createChooseItem("选项2")));
        } else {
            question.setItems(CollUtil.newArrayList(createTextItem("选项1"),
                    createTextItem("选项2"),
                    createTextItem("选项2"),
                    createTextItem("选项2")));
        }
        return question;
    }

    public QuestionnaireEnum getType() {
        double random = Math.random();
        if (random < 0.333) {
            return QuestionnaireEnum.radio;
        }
        if (random < 0.666) {
            return QuestionnaireEnum.checkbox;
        }
        return QuestionnaireEnum.text;
    }

    public BaseItem createItem(String title) {
        BaseItem one = new BaseItem();
        one.setMustWriter(true);
        one.setPrompt(title);
        one.setSort(1);
        one.setTitle(title);
        return one;
    }

    public BaseItem createChooseItem(String title) {
        ChoseQuestionItem one = new ChoseQuestionItem();
        one.setMustWriter(true);
        one.setPrompt(title);
        one.setSort(1);
        one.setTitle(title);
        one.setWeights((int) (Math.random() * 30));
        one.setSort((int) (Math.random() * 30));
        return one;
    }

    public BaseItem createTextItem(String title) {
        FillBlankQuestionItem fillBlankQuestionItem = new FillBlankQuestionItem();
        fillBlankQuestionItem.setHigh(20.0);
        fillBlankQuestionItem.setWidth(20.0);
        fillBlankQuestionItem.setDefaultsValue("hello");
        fillBlankQuestionItem.setMaxSize(2000);
        fillBlankQuestionItem.setMustWriter(true);
        fillBlankQuestionItem.setPrompt(title);
        fillBlankQuestionItem.setSort(1);
        fillBlankQuestionItem.setTitle(title);
        fillBlankQuestionItem.setSort((int) (Math.random() * 30));
        return fillBlankQuestionItem;
    }
}