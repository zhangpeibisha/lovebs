package org.nix.lovedomain.service.file.model;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生课程得分
 * @date 2019/6/1
 */
@Data
public class StudentCourseScoreExcel {

    /**
     * 教学任务id
     */
    private String teachCourseId;

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 该课程的得分
     */
    private Integer score;


}
