package org.nix.lovedomain.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangpei
 * @version 1.0
 * @description 专业展示视图
 * @date 2019/4/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionVo {

    private Integer id;

    private String coding;

    private String name;

    private TeacherVo teacher;

    private FacultyVo facultyVo;

}
