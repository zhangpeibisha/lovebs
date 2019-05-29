package org.nix.lovedomain.dao.business.json.winding;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 * <p>
 * 每个题目的每个选项选择次数实体
 */
@Data
public class StatisticsItemChose {

    /**
     * 选项id
     */
    private String choseId;

    /**
     * 选项描述
     */
    private String description;

    /**
     * 选择次数
     */
    private Integer count = 0;

    /**
     * 该选项在评卷中算多少分
     */
    private Integer score;

    public StatisticsItemChose() {
    }

    public StatisticsItemChose(String choseId, String description, Integer score) {
        this.choseId = choseId;
        this.description = description;
        this.score = score;
    }

    public static StatisticsItemChose toBean(String json) {
        if (StrUtil.isEmpty(json)) {
            return null;
        }
        return JSON.parseObject(json, StatisticsItemChose.class);
    }
}
