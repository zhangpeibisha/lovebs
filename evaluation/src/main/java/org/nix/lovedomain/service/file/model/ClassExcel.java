package org.nix.lovedomain.service.file.model;

import lombok.Data;
import org.nix.lovedomain.service.file.CommonService;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 班级
 * @date 2019/5/23
 */
@Data
public class ClassExcel {
    private String classId;
    private String professionName;
    private String teacherName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClassExcel that = (ClassExcel) o;
        return Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classId);
    }
}
