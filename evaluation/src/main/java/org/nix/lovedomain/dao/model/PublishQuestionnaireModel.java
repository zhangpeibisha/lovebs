package org.nix.lovedomain.dao.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 发布评教卷业务
 * @date 2019/5/12
 */
@Table(name = "publishQuestionnaire")
@NameStyle
@Data
public class PublishQuestionnaireModel {

    @Id
    private Integer id;

    private Integer releaseId;

    private Integer courseId;

    private Integer teacherId;

    private Integer questionnaireId;

    private String description;

    private Date releaseTime;

    private Date startRespondTime;

    private Date endRespondTime;

    private String statistics;


    public JSONObject getStatisticsJson() {
        if (statistics == null) {
            return new JSONObject();
        }
        return JSON.parseObject(statistics);
    }

}
