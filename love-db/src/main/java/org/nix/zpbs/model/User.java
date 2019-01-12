package org.nix.zpbs.model;

import java.io.Serializable;

public class User implements Serializable {
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
     * 用户密码
     *
     * @mbggenerated
     */
    private String userPwd;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Long getUserQq() {
        return userQq;
    }

    public void setUserQq(Long userQq) {
        this.userQq = userQq;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Long getUserMark() {
        return userMark;
    }

    public void setUserMark(Long userMark) {
        this.userMark = userMark;
    }

    public Integer getUserRankId() {
        return userRankId;
    }

    public void setUserRankId(Integer userRankId) {
        this.userRankId = userRankId;
    }

    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    public Long getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Long userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public Long getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Long userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public String getUserRegisterIp() {
        return userRegisterIp;
    }

    public void setUserRegisterIp(String userRegisterIp) {
        this.userRegisterIp = userRegisterIp;
    }

    public Long getUserLastUpdateTime() {
        return userLastUpdateTime;
    }

    public void setUserLastUpdateTime(Long userLastUpdateTime) {
        this.userLastUpdateTime = userLastUpdateTime;
    }

    public String getUserWeibo() {
        return userWeibo;
    }

    public void setUserWeibo(String userWeibo) {
        this.userWeibo = userWeibo;
    }

    public String getUserBloodType() {
        return userBloodType;
    }

    public void setUserBloodType(String userBloodType) {
        this.userBloodType = userBloodType;
    }

    public String getUserSays() {
        return userSays;
    }

    public void setUserSays(String userSays) {
        this.userSays = userSays;
    }

    public Integer getUserActivation() {
        return userActivation;
    }

    public void setUserActivation(Integer userActivation) {
        this.userActivation = userActivation;
    }

    public Integer getUserFreeze() {
        return userFreeze;
    }

    public void setUserFreeze(Integer userFreeze) {
        this.userFreeze = userFreeze;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupId=").append(groupId);
        sb.append(", userName=").append(userName);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userSex=").append(userSex);
        sb.append(", userQq=").append(userQq);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", userMark=").append(userMark);
        sb.append(", userRankId=").append(userRankId);
        sb.append(", userLastLoginIp=").append(userLastLoginIp);
        sb.append(", userBirthday=").append(userBirthday);
        sb.append(", userDescription=").append(userDescription);
        sb.append(", userImageUrl=").append(userImageUrl);
        sb.append(", userSchool=").append(userSchool);
        sb.append(", userRegisterTime=").append(userRegisterTime);
        sb.append(", userRegisterIp=").append(userRegisterIp);
        sb.append(", userLastUpdateTime=").append(userLastUpdateTime);
        sb.append(", userWeibo=").append(userWeibo);
        sb.append(", userBloodType=").append(userBloodType);
        sb.append(", userSays=").append(userSays);
        sb.append(", userActivation=").append(userActivation);
        sb.append(", userFreeze=").append(userFreeze);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}