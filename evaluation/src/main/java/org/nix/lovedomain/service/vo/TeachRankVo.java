package org.nix.lovedomain.service.vo;

import lombok.Data;
import org.nix.lovedomain.dao.model.RankModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 教学任务排名
 * @date 2019/5/31
 */
@Data
public class TeachRankVo {

    /**
     * 学院名字
     */
    private String facultyName;

    /**
     * 排名信息的自增主键
     */
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
     * 这个学院老师排名的详细信息
     */
    private List<RankModel.RankItem> rank;
}
