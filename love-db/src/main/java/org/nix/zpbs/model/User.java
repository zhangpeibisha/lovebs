package org.nix.zpbs.model;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * 用户组ID
     *
     * @mbggenerated
     */
    private Integer groupId;

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
    private Integer userPhone;

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
    private Integer userQq;

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
    private Integer userMark;

    /**
     * 用户等级
     *
     * @mbggenerated
     */
    private Byte userRankId;

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
    private Integer userBirthday;

    /**
     * 自我描述
     *
     * @mbggenerated
     */
    private String userDescription;

    /**
     * 用户头像存储路径
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
    private Integer userRegisterTime;

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
    private Integer userLastUpdateTime;

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
     * 是否锁定，0为不锁定，1为锁定
     *
     * @mbggenerated
     */
    private Byte userLock;

    /**
     * 是否冻结，0为不冻结，1为冻结
     *
     * @mbggenerated
     */
    private Byte userFreeze;

    /**
     * 拥有权限
     *
     * @mbggenerated
     */
    private String userPower;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
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

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserQq() {
        return userQq;
    }

    public void setUserQq(Integer userQq) {
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

    public Integer getUserMark() {
        return userMark;
    }

    public void setUserMark(Integer userMark) {
        this.userMark = userMark;
    }

    public Byte getUserRankId() {
        return userRankId;
    }

    public void setUserRankId(Byte userRankId) {
        this.userRankId = userRankId;
    }

    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    public Integer getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Integer userBirthday) {
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

    public Integer getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(Integer userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public String getUserRegisterIp() {
        return userRegisterIp;
    }

    public void setUserRegisterIp(String userRegisterIp) {
        this.userRegisterIp = userRegisterIp;
    }

    public Integer getUserLastUpdateTime() {
        return userLastUpdateTime;
    }

    public void setUserLastUpdateTime(Integer userLastUpdateTime) {
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

    public Byte getUserLock() {
        return userLock;
    }

    public void setUserLock(Byte userLock) {
        this.userLock = userLock;
    }

    public Byte getUserFreeze() {
        return userFreeze;
    }

    public void setUserFreeze(Byte userFreeze) {
        this.userFreeze = userFreeze;
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
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
        sb.append(", userLock=").append(userLock);
        sb.append(", userFreeze=").append(userFreeze);
        sb.append(", userPower=").append(userPower);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}