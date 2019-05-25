package org.nix.lovedomain.dao.model;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/24
 */
@Data
@NameStyle
@Table(name = "statisticsScore")
public class StatisticsScoreModel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer teacherId;
    private Integer courseId;
    private Integer publishQuestionnaireId;
    private Integer attachJson;
    private Integer fraction;
    private Double avg;
    private Integer classId;
    private Integer professionId;
    private Integer facultyId;

}
