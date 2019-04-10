package org.nix.lovedomain.service.vo;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nix.lovedomain.model.Student;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生展示视图
 * @date 2019/4/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {

    private Integer id;

    private String studentId;

    private String name;

    private String phone;

    private String imageUrl;

    /**
     * 前端展示的字段为class
     */
    @JsonProperty(value = "class")
    private ClassVo claszz;


    public static StudentVo studentToSimpleStudentVo(Student student) {
        return JSONUtil.toBean(JSONUtil.toJsonStr(student), StudentVo.class);
    }
}
