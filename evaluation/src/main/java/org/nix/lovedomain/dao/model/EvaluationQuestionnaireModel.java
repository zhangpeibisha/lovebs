package org.nix.lovedomain.dao.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.question.EvaluationQuestionnaireContent;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/5/24
 */
@Data
@Table(name = "evaluationQuestionnaire")
@NameStyle
public class EvaluationQuestionnaireModel {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String title;

    private String description;

    private Date createTime;

    private Date updateTime;

    private String content;

    private Integer authorAccountId;


}
