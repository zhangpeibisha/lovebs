package org.nix.lovedomain.service.file.model;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 模拟学生数据
 * @date 2019/5/24
 */
@Data
public class StudentExcel {

    /**
     * 班级编号
     */
    private String classId;
    /**
     * 这个班级有多少个学生
     */
    private String studentNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentExcel that = (StudentExcel) o;
        return Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId);
    }
}
