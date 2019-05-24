package org.nix.lovedomain.service.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;

/**
 * @author zhangpei
 * @version 1.0
 * @description 将字符串转换为json
 * @date 2019/5/9
 */
public class PublishQuestionJsonVo extends PublishQuestionnaireModel {

    @Override
    public JSONObject getStatisticsJson() {
        if (getStatistics() == null) {
            return new JSONObject();
        }
        return JSON.parseObject(getStatistics());
    }

    public static PublishQuestionJsonVo publishquestionnaire2Vo(PublishQuestionnaireModel publishquestionnaire){
        if (publishquestionnaire == null){
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(publishquestionnaire),PublishQuestionJsonVo.class);
    }

}
