package org.nix.lovedomain.service.file.model;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 在班级里面学生的数量，然后模拟生成学生信息
 * @date 2019/5/23
 */
@Data
public class ClassStudentExcel {

    private String classId;

    private Integer studentNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClassStudentExcel that = (ClassStudentExcel) o;
        return Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classId);
    }
}
