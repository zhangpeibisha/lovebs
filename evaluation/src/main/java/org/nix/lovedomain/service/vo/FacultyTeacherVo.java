package org.nix.lovedomain.service.vo;

import lombok.Data;
import org.nix.lovedomain.dao.model.TeacherModel;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/6/2
 */
@Data
public class FacultyTeacherVo {

    private Integer id;

    private String coding;

    private String name;

    private TeacherModel dean;
}
