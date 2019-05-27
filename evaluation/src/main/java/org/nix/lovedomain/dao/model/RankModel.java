package org.nix.lovedomain.dao.model;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/5/27
 * @since jdk8
 *
 * 一个学院下发布的问卷排名统计
 */
@Table(name = "rank")
@NameStyle
@Data
public class RankModel {

    /**
     * 排名id
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
    private String year;

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
    private List<Integer> degree;

    /**
     * 排名信息，字符串形式
     * @return
     */
    public String toContent(){
       content = JSONUtil.toJsonStr(degree);
       return content;
    }

    /**
     * 排名信息，数组类型
     * @return
     */
    public List<Integer> toDegree(){
        degree = (List<Integer>) JSONUtil.toBean(content,List.class);
        return degree;
    }

    /**
     * 教师账号id提取
     * @param list
     */
    public void changeList(List<StatisticsScoreModel>  list){
        degree = new ArrayList<>();
        for (StatisticsScoreModel s:
             list) {
         degree.add(s.getTeacherAccountId());
        }
    }

}
