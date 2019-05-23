package org.nix.lovedomain.service.file.model;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学院
 * @date 2019/5/23
 */
@Data
public class FacultyExcel {

    private String facultyName;

    private String facultyId;

    private String teacherName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FacultyExcel that = (FacultyExcel) o;
        return Objects.equals(facultyId, that.facultyId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(facultyId);
    }
}
