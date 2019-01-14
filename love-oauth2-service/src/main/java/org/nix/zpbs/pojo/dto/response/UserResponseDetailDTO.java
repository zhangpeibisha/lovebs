package org.nix.zpbs.pojo.dto.response;

import lombok.Data;

/**
 * 用户查询响应详细信息对象
 * 相对于Model只是减少用户密码信息
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
@Data
public class UserResponseDetailDTO {

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户组ID,默认为使用用户的最少权限
     *
     * @mbggenerated
     */
    private Long groupId;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * 用户手机号码
     *
     * @mbggenerated
     */
    private Long userPhone;

    /**
     * 用户性别
     *
     * @mbggenerated
     */
    private String userSex;

    /**
     * 用户QQ号码
     *
     * @mbggenerated
     */
    private Long userQq;

    /**
     * 用户EMAIL地址
     *
     * @mbggenerated
     */
    private String userEmail;

    /**
     * 用户地址
     *
     * @mbggenerated
     */
    private String userAddress;

    /**
     * 用户积分
     *
     * @mbggenerated
     */
    private Long userMark;

    /**
     * 用户等级
     *
     * @mbggenerated
     */
    private Integer userRankId;

    /**
     * 用户上一次登录IP地址
     *
     * @mbggenerated
     */
    private String userLastLoginIp;

    /**
     * 用户生日
     *
     * @mbggenerated
     */
    private Long userBirthday;

    /**
     * 自我描述
     *
     * @mbggenerated
     */
    private String userDescription;

    /**
     * 用户头像存储路径,使用短地址存储，调用百度短地址
     *
     * @mbggenerated
     */
    private String userImageUrl;

    /**
     * 毕业学校
     *
     * @mbggenerated
     */
    private String userSchool;

    /**
     * 用户注册时间
     *
     * @mbggenerated
     */
    private Long userRegisterTime;

    /**
     * 用户注册时IP地址
     *
     * @mbggenerated
     */
    private String userRegisterIp;

    /**
     * 用户上次更新博客时间
     *
     * @mbggenerated
     */
    private Long userLastUpdateTime;

    /**
     * 用户微博
     *
     * @mbggenerated
     */
    private String userWeibo;

    /**
     * 用户血型
     *
     * @mbggenerated
     */
    private String userBloodType;

    /**
     * 用户语录
     *
     * @mbggenerated
     */
    private String userSays;

    /**
     * 是否激活，0为激活，1为未激活
     *
     * @mbggenerated
     */
    private Integer userActivation;

    /**
     * 是否冻结，0为不冻结，1为冻结
     *
     * @mbggenerated
     */
    private Integer userFreeze;

    private static final long serialVersionUID = 1L;


}
