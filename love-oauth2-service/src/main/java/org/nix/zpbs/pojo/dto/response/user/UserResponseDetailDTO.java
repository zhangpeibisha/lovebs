package org.nix.zpbs.pojo.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 用户查询响应详细信息对象
 * 相对于Model只是减少用户密码信息
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "UserResponseDetailDTO", description = "用户详细信息")
public class UserResponseDetailDTO {

    /**
     * 展示用户基本信息，账户、邮箱、手机号、id
     */
    public interface UserSimpleDTO{}

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    @JsonView(value = UserSimpleDTO.class)
    @ApiModelProperty(value = "用户id")
    private Long id;

    /**
     * 用户组ID,默认为使用用户的最少权限
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户组id")
    private Long groupId;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    @JsonView(value = UserSimpleDTO.class)
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 用户手机号码
     *
     * @mbggenerated
     */
    @JsonView(value = UserSimpleDTO.class)
    @ApiModelProperty(value = "手机号码")
    private Long userPhone;

    /**
     * 用户性别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "性别")
    private String userSex;

    /**
     * 用户QQ号码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "QQ账号")
    private Long userQq;

    /**
     * 用户EMAIL地址
     *
     * @mbggenerated
     */
    @JsonView(value = UserSimpleDTO.class)
    @ApiModelProperty(value = "邮箱地址")
    private String userEmail;

    /**
     * 用户地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "家庭地址")
    private String userAddress;

    /**
     * 用户积分
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "积分")
    private Long userMark;

    /**
     * 用户等级
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "等级")
    private Integer userRankId;

    /**
     * 用户上一次登录IP地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上次登陆IP")
    private String userLastLoginIp;

    /**
     * 用户生日
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "生日")
    private Long userBirthday;

    /**
     * 自我描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "自我描述")
    private String userDescription;

    /**
     * 用户头像存储路径,使用短地址存储，调用百度短地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户头像")
    private String userImageUrl;

    /**
     * 毕业学校
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "毕业学校")
    private String userSchool;

    /**
     * 用户注册时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "注册时间")
    private Long userRegisterTime;

    /**
     * 用户注册时IP地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "注册IP")
    private String userRegisterIp;

    /**
     * 用户上次更新博客时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上次更新博客的时间")
    private Long userLastUpdateTime;

    /**
     * 用户微博
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "微博地址")
    private String userWeibo;

    /**
     * 用户血型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户血型")
    private String userBloodType;

    /**
     * 用户语录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户语录")
    private String userSays;

    /**
     * 是否激活，0为激活，1为未激活
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否激活")
    private Integer userActivation;

    /**
     * 是否冻结，0为不冻结，1为冻结
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否冻结")
    private Integer userFreeze;

    private static final long serialVersionUID = 1L;


}
