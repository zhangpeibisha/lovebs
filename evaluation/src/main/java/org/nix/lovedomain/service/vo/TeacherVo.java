package org.nix.lovedomain.service.vo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nix.lovedomain.model.Teacher;


/**
 * @author zhangpei
 * @version 1.0
 * @description 老师的视图展示
 * @date 2019/4/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherVo {

    private Integer id;

    @JSONField(name = "jobnumber")
    private String jobNumber;

    private String name;

    @JSONField(name = "workjson")
    private String workJson;

    @JSONField(name = "imagerurl")
    private String imageUrl;

    private String email;

    private String phone;

    /**
     * 获取工作配置参数
     *
     * @return json对象
     */
    public JSONObject getWorkJson() {
        if (workJson == null){
            return null;
        }
        return JSONUtil.parseObj(workJson);
    }

    /**
     * 实体转换
     *
     * @param teacher
     * @return
     */
    public static TeacherVo teacherToSimpleTeacherVo(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        return JSON.parseObject(JSONUtil.toJsonStr(teacher),TeacherVo.class);
    }
}
