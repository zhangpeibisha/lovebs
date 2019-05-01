package org.nix.lovedomain.service.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 问卷的列表展示对象
 * @date 2019/4/27
 */
@Data
public class EvaluationquestionnaireSimpleVo {

    private Integer id;

    /**
     * 评教题目
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 评教描述
     *
     * @mbggenerated
     */
    private String descritption;

    private Date createtime;

    private Date updatetime;

    /**
     * 作者信息
     */
    private TeacherSimpleVo author;
}