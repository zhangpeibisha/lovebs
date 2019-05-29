package org.nix.lovedomain.dao.business.json.winding;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.nix.lovedomain.dao.model.StatisticsScoreModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 * <p>
 * 统计的附加信息
 */
@Data
public class StatisticsAttachInfor {

    /**
     * 存放建议
     */
    private List<PublishAttachInfo.Advice> adviseList;

    /**
     * 应该回多少人回答
     */
    private Integer shouldAnswer;

    /**
     * 实际多人回答
     */
    private Integer realityAnswer;

    /**
     * 黑名单人数
     */
    private Integer black;

    /**
     * 选项的统计
     */
    private String statisticsItem;

    public StatisticsAttachInfor() {
    }

    /**
     * 将字符串转成附加信息实体类
     *
     * @param statisticsScoreModel
     * @return
     */
    public static StatisticsAttachInfor toStatisticsAttachInfor(StatisticsScoreModel statisticsScoreModel) {
        String attachJson = statisticsScoreModel.getAttachJson();
        if (StrUtil.isEmpty(attachJson)) {
            return null;
        }
        return JSONUtil.toBean(attachJson, StatisticsAttachInfor.class);
    }

    /**
     * 将字符串转化成每道题的统计实体
     *
     * @return
     */
    public Map<String, StatisticsItem> toItemStatsiticsMap() {
        if (StrUtil.isEmpty(statisticsItem)) {
            return new HashMap<>();
        }
        return JSON.parseObject(this.statisticsItem, new TypeReference<Map<String, StatisticsItem>>() {
        });
    }
}
