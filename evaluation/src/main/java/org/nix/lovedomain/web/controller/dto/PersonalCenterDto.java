package org.nix.lovedomain.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangpei
 * @version 1.0
 * @description 个人中心返回信息结构
 * @date 2019/5/1
 */
@Data
@AllArgsConstructor
public class PersonalCenterDto {

    private UserType userType;

    private Object userInfo;

    public enum UserType {
        /**
         * 用户类型
         */
        TEACHER, STUDENT;
    }

}
