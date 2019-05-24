package org.nix.lovedomain.dao.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
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
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 该次发布的执行者的账号id
     */
    private Integer releaseAccountId;

    /**
     * 课程自增主键id
     */
    private Integer courseId;

    /**
     * 授课老师的账号id
     */
    private Integer teacherAccountId;

    /**
     * 评教卷id
     */
    private Integer questionnaireId;

    /**
     * 发布的意义或者说明
     */
    private String description;

    /**
     * 创建时间
     */
    private Date releaseTime;
    /**
     * 开始回答时间
     */
    private Date startRespondTime;
    /**
     * 结束回答时间
     */
    private Date endRespondTime;
    /**
     * 数据临时统计
     */
    private String statistics;
    /**
     * 学年
     */
    private Integer year;
    /**
     * 学期
     */
    private String semester;
    /**
     * 对应的教学任务id
     */
    private String teachCourseId;

    /**
     * 统计信息转json
     *
     * @return
     */
    public JSONObject getStatisticsJson() {
        if (statistics == null) {
            return new JSONObject();
        }
        return JSON.parseObject(statistics);
    }

}
