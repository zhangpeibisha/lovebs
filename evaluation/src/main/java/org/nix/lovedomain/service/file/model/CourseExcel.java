package org.nix.lovedomain.service.file.model;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 课程信息导入
 * @date 2019/5/23
 */
@Data
public class CourseExcel {

    /**
     * 课程在学校的课程id
     */
    private String courseCoding;
    /**
     * 课程名字
     */
    private String courseName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseExcel that = (CourseExcel) o;
        return Objects.equals(courseCoding, that.courseCoding);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseCoding);
    }
}
