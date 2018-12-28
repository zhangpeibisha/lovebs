package org.nix.zhangpei.love.recording.service;

import com.alibaba.fastjson.JSON;
import org.nix.zhangpei.love.recording.controller.dto.CheckException;
import org.nix.zhangpei.love.recording.controller.dto.user.UserLoginDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserRegisterDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserSelectDTO;
import org.nix.zhangpei.love.recording.controller.dto.user.UserUpdateDTO;
import org.nix.zhangpei.love.recording.dao.mapper.UserMapper;
import org.nix.zhangpei.love.recording.dao.po.UserPO;
import org.nix.zhangpei.love.recording.service.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户登陆信息校验
     *
     * @param login 用户登陆输入信息
     */
    public UserVO checkLoginInfo(UserLoginDTO login) {
        try {
            boolean pass = login.pass();
            if (pass) {
                UserPO userPO = new UserPO();
                userPO.setPassword(login.getPassword());
                userPO.setPhone(login.getPhone());
                userPO.setUsername(login.getUsername());
                UserPO result = userMapper.selectOne(userPO);
                if (result == null) {
                    throw new ServiceException("账号/手机号/密码输入有错");
                }
                return new UserVO(result);
            } else {
                throw new ServiceException("用户输入异常,登陆失败");
            }
        } catch (CheckException e) {
            throw new ServiceException("用户输入异常,登陆失败" + e.getMessage());
        }
    }

    /**
     * 用户注册信息
     * 1. 检查该账户是否已经注册过
     * 2. 执行注册
     * 3. 检测注册执行情况
     *
     * @param register 注册信息
     */
    public void register(UserRegisterDTO register) {
        try {
            boolean pass = register.pass();
            if (pass) {
                UserSelectDTO selectDTO = new UserSelectDTO();
                String phone = register.getPhone();
                selectDTO.setPhone(phone);
                String username = register.getUsername();
                selectDTO.setUsername(username);
                UserVO userOne = findUserOne(selectDTO);
                if (userOne != null) {
                    throw new ServiceException(String.format("%s已经被注册", JSON.toJSON(selectDTO)));
                }
                UserPO userPO = new UserPO();
                userPO.setUsername(username);
                userPO.setPhone(phone);
                userPO.setPassword(register.getPassword());
                userPO.baseCreate();
                int insert = userMapper.insert(userPO);
                if (insert != 1) {
                    throw new ServiceException("注册失败，插入数据不等于1");
                }
            }
        } catch (CheckException e) {
            throw new ServiceException("用户输入异常，不执行注册操作" + e.getMessage());
        }
    }

    /**
     * 查询一个用户的信息
     * 1.用户不能使用空数据来请求查询,将抛出检查异常
     * 2.由于是查询一个人的信息，所以查询出来不允许有多个信息
     *
     * @param select 查询的条件
     * @return 用户信息, 如果没有找到则返回null
     */
    public UserVO findUserOne(UserSelectDTO select) {
        try {
            boolean pass = select.pass();
            if (pass) {
                UserPO userPO = new UserPO();
                userPO.setPhone(select.getPhone());
                userPO.setUsername(select.getUsername());
                userPO.setId(select.getId());
                UserPO result = userMapper.selectOne(userPO);
                if (result == null) {
                    return null;
                }
                return new UserVO(result);
            }
            return null;
        } catch (CheckException e) {
            throw new ServiceException("用户请求异常，不执行查询操作" + e.getMessage());
        }
    }

    /**
     * 更新用户基本信息
     * 1.由于更新用户信息，那么肯定只有id是确定的信息，因此采用id查询用户信息
     * 2.如果查到用户信息则更新，如果没有找到则抛出异常
     * 3.用户在修改时需要提供密码信息
     *
     * @param update 更新用户的基本信息
     */
    public UserVO updateUser(UserUpdateDTO update) {
        // 使用登陆信息校验
        UserVO userVO = checkLoginInfo(update.getLogin());
        if (userVO == null) {
            throw new ServiceException("校验用户信息失败");
        }
        boolean isUpdate = false;
        // 查询用户完成信息
        UserPO select = userMapper.selectByPrimaryKey(userVO.getId());
        if (select == null){
            throw new ServiceException("查询用户信息失败");
        }
        String password = update.getNewPassword();
        // 如果密码不为空且密码不和旧密码相同，则更新
        if (password != null && !select.getPassword().equals(update.getNewPassword())) {
            select.setPassword(password);
            isUpdate =true;
        }
        String username = update.getNewUsername();
        if (username != null && !select.getUsername().equals(username)) {
            select.setUsername(username);
            isUpdate =true;
        }
        String phone = update.getNewPhone();
        if (phone != null && !select.getPhone().equals(phone)) {
            select.setPhone(phone);
            isUpdate =true;
        }
        // 如果执行过更新，则更新数据库
        if (isUpdate){
            userMapper.updateByPrimaryKey(select);
        }
        select.baseUpdate();
        return new UserVO(select);
    }

    /**
     * 删除用户的信息
     *
     * @param delete 选定删除条件
     */
    public void deleteUser(UserLoginDTO delete) {

    }

}
