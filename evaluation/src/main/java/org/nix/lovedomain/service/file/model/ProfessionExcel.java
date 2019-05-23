package org.nix.lovedomain.service.file.model;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangpei
 * @version 1.0
 * @description 专业
 * @date 2019/5/23
 */
@Data
public class ProfessionExcel {

    private String professionName;

    private String professionId;

    private String facultyName;

    private String teacherName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfessionExcel that = (ProfessionExcel) o;
        return Objects.equals(professionId, that.professionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(professionId);
    }
}
