package org.nix.lovedomain.service.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.nix.lovedomain.model.Publishquestionnaire;

/**
 * @author zhangpei
 * @version 1.0
 * @description 将字符串转换为json
 * @date 2019/5/9
 */
public class PublishQuestionJsonVo extends Publishquestionnaire {

    public JSONObject getStatisticsJson() {
        if (getStatistics() == null) {
            return new JSONObject();
        }
        return JSON.parseObject(getStatistics());
    }

}
