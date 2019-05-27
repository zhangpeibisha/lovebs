package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/24
 */
@Data
@NameStyle
@Table(name = "statisticsScore")
public class StatisticsScoreModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 课程所属老师账号
     */
    private Integer teacherAccountId;

    /**
     * 课程Id
     */
    private Integer courseId;

    /**
     * 问卷Id
     */
    private Integer publishQuestionnaireId;

    /**
     * 问卷的附加信息
     */
    private String attachJson;

    /**
     * 统计的分数
     */
    private Double score = 0D;

    /**
     * 统计未读
     * 1 代表问卷的总分统计
     * 2 代表问卷的平均分统计  总分/（总人数-黑名单生数量）
     * 3 代表每项平均分
     * 4 代表每个想被多少人统计
     */
    private Integer type;

}
