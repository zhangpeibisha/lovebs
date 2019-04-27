package org.nix.lovedomain.service.vo;

import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师的简约信息返回
 * @date 2019/4/27
 */
@Data
public class TeacherSimpleVo {
    private Integer id;

    private String jobNumber;

    private String name;

    private String imageUrl;

    private Correspondence correspondence;

    @Data
    public static class Correspondence{
        private String phone;
        private String email;
    }
}
