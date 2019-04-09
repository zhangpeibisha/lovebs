package org.nix.lovedomain.service.vo;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    private String jobNumber;

    private String name;

    private String workJson;

    private String imageUrl;

    /**
     * 获取工作配置参数
     *
     * @return json对象
     */
    public JSONObject getWorkJson() {
        return JSONUtil.parseObj(workJson);
    }

}
