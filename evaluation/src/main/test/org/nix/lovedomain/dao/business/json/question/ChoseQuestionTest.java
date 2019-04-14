package org.nix.lovedomain.dao.business.json.question;

import cn.hutool.json.JSONUtil;
import org.junit.Test;
import org.nix.lovedomain.dao.business.json.question.base.BaseQuestion;


public class ChoseQuestionTest {

    @Test
    public void choseTest() {
        BaseQuestion<ChoseQuestionItem> choseQuestionItemBaseQuestion = new BaseQuestion<>();
        choseQuestionItemBaseQuestion.setMustWriter(false);
        choseQuestionItemBaseQuestion.setPrompt("上课纪律好不好");
        choseQuestionItemBaseQuestion.setQuestionnaireType(QuestionnaireEnum.CHOSE_SINGLE);
        choseQuestionItemBaseQuestion.setTitle("纪律");

        ChoseQuestionItem choseQuestionItem = new ChoseQuestionItem();
        choseQuestionItem.setMustWriter(false);
        choseQuestionItem.setTitle("很满意");
        choseQuestionItem.setPrompt("对老师的上课纪律评价");
        choseQuestionItem.setSort(5);
        choseQuestionItem.setWeights(20);
        choseQuestionItem.setDefaults(true);
        choseQuestionItemBaseQuestion.addItem(choseQuestionItem);

        ChoseQuestionItem nolmall = new ChoseQuestionItem();
        nolmall.setMustWriter(true);
        nolmall.setTitle("一般");
        nolmall.setPrompt("对老师的上课纪律评价");
        nolmall.setSort(4);
        nolmall.setWeights(10);
        choseQuestionItemBaseQuestion.addItem(nolmall);

        System.out.println(JSONUtil.toJsonStr(choseQuestionItemBaseQuestion));
    }

    @Test
    public void fillBlank() {
        BaseQuestion<FillBlankQuestionItem> fillBlankQuestionItemBaseQuestion = new BaseQuestion<>();
        fillBlankQuestionItemBaseQuestion.setMustWriter(false);
        fillBlankQuestionItemBaseQuestion.setPrompt("对老师的看法");
        fillBlankQuestionItemBaseQuestion.setQuestionnaireType(QuestionnaireEnum.FILL_BLANK_SINGLE);
        fillBlankQuestionItemBaseQuestion.setTitle("老师印象");

        FillBlankQuestionItem fillBlankQuestion = new FillBlankQuestionItem();
        fillBlankQuestion.setHigh(10D);
        fillBlankQuestion.setWidth(10D);
        fillBlankQuestion.setMaxSize(200);
        fillBlankQuestion.setDefaults(false);
        fillBlankQuestion.setTitle("和蔼可亲");
        fillBlankQuestion.setMustWriter(true);
        fillBlankQuestion.setPrompt("老师对待学生的态度");
        fillBlankQuestion.setSort(1);
        fillBlankQuestionItemBaseQuestion.addItem(fillBlankQuestion);

        FillBlankQuestionItem youmo = new FillBlankQuestionItem();
        youmo.setDefaults(true);
        youmo.setHigh(10D);
        youmo.setWidth(10D);
        youmo.setMaxSize(200);
        youmo.setDefaultsValue("老师很幽默");
        youmo.setTitle("幽默");
        youmo.setPrompt("老师的说话方式");
        youmo.setSort(2);
        youmo.setMustWriter(true);
        fillBlankQuestionItemBaseQuestion.addItem(youmo);

        System.out.println(JSONUtil.toJsonStr(fillBlankQuestionItemBaseQuestion));
    }
}