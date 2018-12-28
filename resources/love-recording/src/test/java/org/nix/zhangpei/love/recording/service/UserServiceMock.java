package org.nix.zhangpei.love.recording.service;

import org.nix.zhangpei.love.recording.dao.po.UserPO;
import org.nix.zhangpei.love.recording.service.vo.UserVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户服务有
 * 1. 通过用户名查询到用户信息
 * 2. 通过用户手机号查询到用户信息
 * 3. 通过用户信息和手机号信息注册用户
 * 4. 通过旧密码修改密码
 * 5. 登陆服务
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class UserServiceMock {

    private List<UserPO> userMocks = new ArrayList<UserPO>(10);

    {
        UserPO userPO = new UserPO();
        userPO.setPassword("bisha520");
        userPO.setPhone("18203085236");
        userPO.setUsername("zhangpei");
        userPO.setId(1L);
        userPO.setCreateTime(System.currentTimeMillis());
        userPO.setUpdateTime(System.currentTimeMillis());
        userMocks.add(userPO);
    }

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    public UserVO findUserByUserName(String username){
        for (UserPO user : userMocks) {
            if (user.getUsername().equals(username)){
                return new UserVO(user);
            }
        }
        return null;
    }

    /**
     * 通过用户名查询用户信息
     * @param phone 用户手机号
     * @return 用户信息
     */
    public UserVO findUserByUserPhone(String phone){
        return null;
    }

    public UserVO loginByUserName(String username,String password){
        return null;
    }

    public UserVO loginByUserPhone(String username,String password){
        return null;
    }

    /**
     * 业务逻辑
     * 1. 首先查询用户名和手机号是否已经注册过
     * 2. 如果注册过，那么抛出服务异常，并说明情况
     * 3. 如果都没使用过则开始将用户信息导入数据库
     * @param username 用户名
     * @param phone 用户电话
     * @param password 用户密码
     */
    public void registerUser(String username,String phone,String password){
        UserVO userByUserName = findUserByUserName(username);

    }

    public void updatePasswordByUserNameAndPassword(String username,String oldPassword,String newPassword){

    }

    public void updatePasswordByUserPhoneAndPassword(String phone,String oldPassword,String newPassword){

    }


}
