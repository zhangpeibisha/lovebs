package org.nix.lovedomain.dao.model;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 * <p>
 * 一个学院下发布的问卷排名统计
 */
@Table(name = "rank")
@NameStyle
@Data
public class RankModel {

    /**
     * 排名自增id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 学院id
     */
    private Integer facultyId;

    /**
     * 年份
     */
    private Integer year;

    /**
     * 学期
     */
    private String semester;

    /**
     * 排名内容对应数据库
     */
    private String content;

    /**
     * 排名内容
     */
    private List<RankItem> degree;

    /**
     * 排名信息，字符串形式
     *
     * @return
     */
    public String toContent() {
        content = JSONUtil.toJsonStr(degree);
        return content;
    }

    public List<RankItem> getRank() {
        if (!StrUtil.isEmpty(content)) {
            return JSON.parseArray(content, RankItem.class);
        }
        return degree;
    }

    /**
     * 教师账号id提取
     *
     * @param list
     */
    public void addRankItem(List<RankItem> list) {
        if (degree == null) {
            degree = new ArrayList<>();
        }
        degree.addAll(list);
    }

    @Data
    public static class RankItem {
        /**
         * 教师账号id
         */
        private Integer teacherAccountId;
        /**
         * 教师名字
         */
        private String teacherName;
        /**
         * 教学任务Id
         */
        private String teachCourseId;
        /**
         * 课程id
         */
        private Integer courseId;
        /**
         * 课程名字
         */
        private String courseName;
        /**
         * 总分
         */
        private Double avgScore;
        /**
         * 发布的评教卷id
         */
        private Integer publishQuestionId;
    }
}
