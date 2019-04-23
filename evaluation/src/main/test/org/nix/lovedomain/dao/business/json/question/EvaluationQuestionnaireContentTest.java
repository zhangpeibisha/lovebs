package org.nix.lovedomain.dao.business.json.question;

import cn.hutool.json.JSONUtil;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;
import org.nix.lovedomain.model.Evaluationquestionnaire;

import java.util.Date;

public class EvaluationQuestionnaireContentTest {

    @Test
    public void questionContent() {

        // 单选加入
        BaseQuestion<ChoseQuestionItem> radio = new BaseQuestion<>();
        radio.setTitle("上课纪律");
        radio.setQuestionnaireType(QuestionnaireEnum.CHOSE_SINGLE);
        radio.setPrompt("老师在上课的时候对课堂的纪律掌握情况");
        radio.setMustWriter(true);
        radio.setId(String.valueOf(1));

        ChoseQuestionItem goodDiscipline = new ChoseQuestionItem();
        goodDiscipline.setTitle("优秀");
        goodDiscipline.setSort(1);
        goodDiscipline.setPrompt("老师上课的情况十分优秀");
        goodDiscipline.setMustWriter(true);
        goodDiscipline.setId(String.valueOf(1));
        goodDiscipline.setDefaults(true);
        goodDiscipline.setWeights(20);
        radio.addItem(goodDiscipline);

        ChoseQuestionItem fineDiscipline = new ChoseQuestionItem();
        fineDiscipline.setTitle("良好");
        fineDiscipline.setSort(2);
        fineDiscipline.setPrompt("老师上课的情况比较优秀");
        fineDiscipline.setMustWriter(true);
        fineDiscipline.setId(String.valueOf(2));
        fineDiscipline.setDefaults(false);
        fineDiscipline.setWeights(10);
        radio.addItem(fineDiscipline);

        ChoseQuestionItem commonDiscipline = new ChoseQuestionItem();
        commonDiscipline.setTitle("一般");
        commonDiscipline.setSort(3);
        commonDiscipline.setPrompt("老师上课的情况能够维持正常上课次序");
        commonDiscipline.setMustWriter(true);
        commonDiscipline.setId(String.valueOf(3));
        commonDiscipline.setDefaults(false);
        commonDiscipline.setWeights(5);
        radio.addItem(commonDiscipline);

        ChoseQuestionItem keepItUpDiscipline = new ChoseQuestionItem();
        keepItUpDiscipline.setTitle("继续努力");
        keepItUpDiscipline.setSort(4);
        keepItUpDiscipline.setPrompt("老师上课的情况不能够维持正常上课次序");
        keepItUpDiscipline.setMustWriter(true);
        keepItUpDiscipline.setId(String.valueOf(4));
        keepItUpDiscipline.setDefaults(false);
        keepItUpDiscipline.setWeights(0);
        radio.addItem(keepItUpDiscipline);

        System.out.println("单选题：");
        System.out.println(JSONUtil.toJsonStr(radio));

        // 多选
        BaseQuestion<ChoseQuestionItem> multipleSelection = new BaseQuestion<>();
        multipleSelection.setTitle("你喜欢什么样的老师");
        multipleSelection.setQuestionnaireType(QuestionnaireEnum.CHOSE_MULTI);
        multipleSelection.setPrompt("老师在上课的时候对老师性格的期望");
        multipleSelection.setMustWriter(true);
        multipleSelection.setId(String.valueOf(0));

        ChoseQuestionItem humor = new ChoseQuestionItem();
        humor.setTitle("幽默的");
        humor.setSort(1);
        humor.setPrompt("老师说话容易理解和比较容易接受的");
        humor.setMustWriter(true);
        humor.setId(String.valueOf(2));
        humor.setDefaults(true);
        humor.setWeights(20);
        multipleSelection.addItem(humor);

        ChoseQuestionItem serious = new ChoseQuestionItem();
        serious.setTitle("严肃的");
        serious.setSort(2);
        serious.setPrompt("老师说话讲课感觉比较不苟言笑");
        serious.setMustWriter(true);
        serious.setId(String.valueOf(3));
        serious.setDefaults(false);
        serious.setWeights(20);
        multipleSelection.addItem(serious);

        ChoseQuestionItem helpful = new ChoseQuestionItem();
        helpful.setTitle("乐于助人的");
        helpful.setSort(2);
        helpful.setPrompt("老师比较喜欢帮助同学解答问题");
        helpful.setMustWriter(true);
        helpful.setId(String.valueOf(5));
        helpful.setDefaults(false);
        helpful.setWeights(20);
        multipleSelection.addItem(helpful);

        // 简单题
        BaseQuestion<FillBlankQuestionItem> shortAnswer = new BaseQuestion<>();
        shortAnswer.setTitle("你对这门课程的建议");
        shortAnswer.setQuestionnaireType(QuestionnaireEnum.FILL_BLANK_SINGLE);
        shortAnswer.setPrompt("你对这门课程的建议");
        shortAnswer.setMustWriter(true);
        shortAnswer.setId(String.valueOf(5));

        FillBlankQuestionItem suggest = new FillBlankQuestionItem();
        suggest.setTitle("你的建议");
        suggest.setSort(1);
        suggest.setPrompt("你对这门课有什么想说的");
        suggest.setId(String.valueOf(121564));
        suggest.setMaxSize(500);
        suggest.setDefaults(true);
        suggest.setDefaultsValue("期望你的回答");
        suggest.setMustWriter(true);
        suggest.setWidth(10D);
        suggest.setHigh(10D);
        shortAnswer.addItem(suggest);

        EvaluationQuestionnaireContent content = new EvaluationQuestionnaireContent();
        content.addQuestion(radio);
        content.addQuestion(multipleSelection);
        content.addQuestion(shortAnswer);

        Evaluationquestionnaire evaluationquestionnaire = new Evaluationquestionnaire();
        evaluationquestionnaire.setId(1);
        evaluationquestionnaire.setAuthorid("12222");
        evaluationquestionnaire.setContent(JSONUtil.toJsonStr(content));
        evaluationquestionnaire.setCreatetime(new Date());
        evaluationquestionnaire.setDescritption("张沛的第一个测试问卷");
        evaluationquestionnaire.setTitle("测试问卷");
        evaluationquestionnaire.setUpdatetime(new Date());
        evaluationquestionnaire.setContent(JSONUtil.toJsonStr(content));

        Result result = Result.builder()
                .code(200)
                .msg("请求成功")
                .data(evaluationquestionnaire).build();


        EvaluationQuestionnaireContent contentBean = EvaluationQuestionnaireContent.getContentBean(evaluationquestionnaire);
        System.out.println(contentBean);

        System.out.println("=============================");
        System.out.println(JSONUtil.toJsonStr(result));
    }

    @Data
    @Builder
    static class Result {
        private Integer code;
        private String msg;
        private Evaluationquestionnaire data;
    }

}