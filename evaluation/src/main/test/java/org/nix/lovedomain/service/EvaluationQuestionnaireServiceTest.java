package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.lovedomain.EvaluationApplication;
import org.nix.lovedomain.dao.business.AccountBusinessMapper;
import org.nix.lovedomain.dao.business.EvaluationQuestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.json.question.ChoseQuestionItem;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import org.nix.lovedomain.dao.business.json.question.QuestionnaireEnum;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.service.file.TaskService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EvaluationApplication.class)
public class EvaluationQuestionnaireServiceTest {

    @Resource
    private EvaluationQuestionnaireService evaluationQuestionnaireService;

    @Resource
    private AccountBusinessMapper accountBusinessMapper;

    @Resource
    private PublishQuestionnaireService publishQuestionnaireService;

    @Resource
    private TaskService taskService;

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    private String bash = "C:/WorkPace/GIT/lovebs/lovebs/doc/excel/";
    String path = bash + "18-19(2)任务书1205.xls";

    /**
     * 创建一个问卷并生成2个题目
     */
    @Test
    @Transactional
    public void createSimpleQuestion() {
        // 第一步：创建评教卷
//        Principal principal = () -> findAccount().getNumbering();
//        EvaluationQuestionnaireModel simpleQuestion
//                = evaluationQuestionnaireService.createSimpleQuestion("张沛的测试评教卷",
//                "张沛的测试评教卷",
//                principal);
//        EvaluationQuestionnaireModel questionnaireModel = evaluationQuestionnaireService.addQuestion(simpleQuestion.getId(),
//                CollUtil.newArrayList(createBaseQuestion("第一个问题"),
//                        createBaseQuestion("第二个问题"),
//                        createBaseQuestion("第三个问题")), principal);
        // 第二步：发布老师教学任务、学生上课任务、评教任务
//        AccountModel account
//                = accountBusinessMapper.findAccountByNumberOrPhoneOrEmail(principal.getName());
//        taskService.insertTeachTask(path,account.getId());
        // 由于评教卷的id放在了excel中不可控，需要集体刷新下评教任务中的评教卷id
//        Integer questionnaireModelId = questionnaireModel.getId();
//        publishQuestionBusinessMapper.updateQuestionId(questionnaireModelId);
//        System.err.println("生成的发布Id" + questionnaireModelId);
        // 回答问题
//        answer();
    }

    /**
     * 选择第一个账号为创建问卷人
     *
     * @return
     */
    public AccountModel findAccount() {
        List<AccountModel> accountModels = accountBusinessMapper.selectAll();
        return accountModels.get(0);
    }

    /**
     * 创建一个题目
     *
     * @return
     */
    public BaseQuestion createBaseQuestion(String title) {
        ChoseQuestionItem one = new ChoseQuestionItem();
        one.setSort(10);
        one.setWeights(20);
        one.setTitle(title + "20分的选项");

        ChoseQuestionItem two = new ChoseQuestionItem();
        two.setSort(10);
        two.setWeights(10);
        two.setTitle(title + "10分的选项");

        BaseQuestion<ChoseQuestionItem> objectBaseQuestion = new BaseQuestion<>();
        objectBaseQuestion.setQuestionnaireType(QuestionnaireEnum.radio);
        objectBaseQuestion.setTitle("测试题目");
        objectBaseQuestion.addItem(one);
        objectBaseQuestion.addItem(two);

        return objectBaseQuestion;
    }


    public void answer() {
        List<PublishQuestionnaireModel> questionnaireModelList = publishQuestionBusinessMapper.selectAll();
        // 随便提取一个发布的评教卷
        Random random = new Random();
        PublishQuestionnaireModel questionnaireModel = questionnaireModelList.get(random.nextInt(questionnaireModelList.size()));
        Integer questionnaireModelId = questionnaireModel.getId();
        System.err.println("这次选中的发布为：" + questionnaireModelId);

        PublishAttachInfo publishAttachInfo = PublishAttachInfo.getBean(questionnaireModel);
        studentAnswer(publishAttachInfo, questionnaireModel);
        studentAnswer(publishAttachInfo, questionnaireModel);
        studentAnswer(publishAttachInfo, questionnaireModel);
    }

    /**
     *  一个学生的回答
     * @param publishAttachInfo
     * @param questionnaireModel
     */
    public void studentAnswer(PublishAttachInfo publishAttachInfo, PublishQuestionnaireModel questionnaireModel) {
        Random random = new Random();
        // 随便获取了一个学生信息
        List<Integer> students = publishAttachInfo.getStudents();
        Integer studentAccountId = students.get(random.nextInt(students.size()));
        System.err.println("这次选中的学生为：" + studentAccountId);
        AccountModel accountModel = accountBusinessMapper.selectByPrimaryKey(studentAccountId);

        Integer questionnaireId = questionnaireModel.getQuestionnaireId();
        EvaluationQuestionnaireModel evaluationQuestionnaireModel = evaluationQuestionnaireBusinessMapper.selectByPrimaryKey(questionnaireId);

        publishQuestionnaireService.fillInTheAnswer(questionnaireModel.getId(),
                studentAnswer(evaluationQuestionnaireModel), accountModel::getNumbering);
    }

    /**
     * 创建 学生回答信息
     * 根据教学任务号进行回答评教卷
     */
    public PublishAttachInfo.CompletesQuestion studentAnswer(EvaluationQuestionnaireModel questionnaireModel) {
        EvaluationQuestionnaireContent content = EvaluationQuestionnaireContent.getContentBean(questionnaireModel);
        List<BaseQuestion> questions = content.getQuestions();
        if (CollUtil.isEmpty(questions)) {
            return null;
        }

        List<PublishAttachInfo.QuestionReply> questionReplies = new ArrayList<>();
        Random random = new Random();

        questions.forEach(question -> {
            List<ChoseQuestionItem> questionItemList = getChoseQuestionItemList(question);
            PublishAttachInfo.QuestionReply questionReply = new PublishAttachInfo.QuestionReply();
            questionReply.setQuestionId(question.getId());
            int randomChoose = random.nextInt(questionItemList.size());
            String chooseId = questionItemList.get(randomChoose).getId();
            questionReply.setChooseId(chooseId);
            questionReplies.add(questionReply);
        });

        PublishAttachInfo.CompletesQuestion completesQuestion = new PublishAttachInfo.CompletesQuestion();
        completesQuestion.setQuestionReplies(questionReplies);

        return completesQuestion;
    }

    private List<ChoseQuestionItem> getChoseQuestionItemList(BaseQuestion question) {
        List items = question.getItems();
        return JSON.parseObject(JSON.toJSONString(items), new TypeReference<List<ChoseQuestionItem>>() {
        });
    }

}