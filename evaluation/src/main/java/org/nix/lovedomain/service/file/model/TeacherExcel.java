package org.nix.lovedomain.service.file.model;

import lombok.Data;
import org.nix.lovedomain.service.file.CommonService;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师信息
 * @date 2019/5/23
 */
@Data
public class TeacherExcel {
    private String teacherName;
    private String professionName;
    private String classId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TeacherExcel that = (TeacherExcel) o;
        return Objects.equals(teacherName, that.teacherName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teacherName);
    }
}
