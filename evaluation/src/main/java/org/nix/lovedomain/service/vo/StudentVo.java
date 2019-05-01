package org.nix.lovedomain.service.vo;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
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

    @JSONField(name = "studentid")
    private String studentId;

    private String name;

    private String phone;

    @JSONField(name = "imageurl")
    private String imageUrl;

    private String task;

    /**
     * 前端展示的字段为class
     */
    @JsonProperty(value = "class")
    private ClassVo classzz;


    public static StudentVo studentToSimpleStudentVo(Student student) {
        return JSON.parseObject(JSONUtil.toJsonStr(student), StudentVo.class);
    }
}
