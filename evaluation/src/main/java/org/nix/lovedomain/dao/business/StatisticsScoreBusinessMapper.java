package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.StatisticsScoreModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/24
 */
public interface StatisticsScoreBusinessMapper extends BaseBusinessMapper<StatisticsScoreModel> {

      /**
       * 统计信息查询
       * @param id
       * @param type
       * @return
       */
      StatisticsScoreModel getPQNa(@Param("id") Integer id,@Param("type") Integer type);

      /**
       * 统计信息查询，用于排名统计
       * @param list
       * @return
       */
      List<StatisticsScoreModel> selectByCollection(@Param("list") List<Integer> list);
}
