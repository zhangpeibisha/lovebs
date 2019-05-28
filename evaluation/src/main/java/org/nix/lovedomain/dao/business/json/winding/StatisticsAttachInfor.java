package org.nix.lovedomain.dao.business.json.winding;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.nix.lovedomain.dao.model.StatisticsScoreModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 *
 * 统计的附加信息
 */
@Data
public class StatisticsAttachInfor {

    /**
     * 存放建议
     */
    private  List<String> adviseList;

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

    /**
     * 将字符串转成附加信息实体类
     * @param statisticsScoreModel
     * @return
     */
    public static StatisticsAttachInfor toStatisticsAttachInfor(StatisticsScoreModel statisticsScoreModel){
        return JSONUtil.toBean(statisticsScoreModel.getAttachJson(),StatisticsAttachInfor.class);
    }

    /**
     * 将字符串转化成每道题的统计实体
     * @return
     */
    public  Map<Integer,StatisticsItem> toItemStatsiticsMap(){
        return JSONUtil.toBean(this.statisticsItem,HashMap.class);
    }
}
