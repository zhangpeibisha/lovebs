package org.nix.lovedomain.service.file.model;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生上课任务
 * @date 2019/5/24
 */
@Data
public class StudentTaskExcel {

    /**
     * 班级在学校的唯一编码
     */
    private String classCoding;
    /**
     * 教学任务的唯一编码
     */
    private String teachCourseId;

}
