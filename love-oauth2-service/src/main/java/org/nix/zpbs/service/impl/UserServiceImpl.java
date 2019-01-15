package org.nix.zpbs.service.impl;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.zpbs.dao.UserGroupDao;
import org.nix.zpbs.exception.ServiceException;
import org.nix.zpbs.mapper.UserMapper;
import org.nix.zpbs.model.User;
import org.nix.zpbs.model.UserExample;
import org.nix.zpbs.pojo.dto.request.user.UserRegisterDTO;
import org.nix.zpbs.pojo.dto.response.user.UserResponseDetailDTO;
import org.nix.zpbs.service.UserService;
import org.nix.zpbs.utils.CusAccessObjectUtil;
import org.nix.zpbs.utils.PojoadAptationUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/10
 */
@Service
@Data
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserGroupDao userGroupDao;

    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * @param account 账户包括（用户名、用户邮箱、用户手机号）
     * @return 用户的详细信息
     */
    @Override
    public User getUserByAccount(String account) {
        if (account == null) {
            throw new ServiceException("无效的用户名或者密码");
        }
        UserExample example = new UserExample();
        example.or().andUserNameEqualTo(account);
        try {
            // 如果抛异常则不会加入条件判断
            long value = Long.parseLong(account);
            example.or().andUserPhoneEqualTo(value);
        } catch (NumberFormatException e) {
            // 不是数字抛异常，忽略处理
        }
        example.or().andUserEmailEqualTo(account);
        List<User> users = userMapper.selectByExample(example);
        if (users == null || users.size() != 1) {
            if (users != null) {
                log.info("用户{}账户为空或者存在多个相同账户名的账户", JSONUtil.toJsonPrettyStr(users));
            }
            throw new ServiceException("无效的用户名或者密码");
        }
        return users.get(0);
    }

    @Override
    public UserResponseDetailDTO getUserDetailDtoByAccount(String account) {
        return PojoadAptationUtil.convertPojo(getUserByAccount(account), UserResponseDetailDTO.class);
    }

    /**
     * TODO 通过用户id获取用户所有的权限id
     *
     * @param userId 用户id
     * @return 用户权限id集合
     */
    @Override
    public List<String> getPowersByUserId(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return userGroupDao.getResourcesNameByUserGroupId(user.getGroupId());
    }


    /**
     * 用户注册接口
     * 1. 如果用户名已经存在则不能注册
     * 2. 注册信息如有有为空的拒绝服务
     * 3. 正确输入完成注册
     *
     * @param userRegisterDTO 用户注册信息
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void register(UserRegisterDTO userRegisterDTO, HttpServletRequest request) {
        try {
            User user = PojoadAptationUtil.convertPojo(userRegisterDTO, User.class);
            // 配置用户的注册信息
            String ipAddress = CusAccessObjectUtil.getIpAddress(request);
            user.setUserRegisterIp(ipAddress);
            user.setUserRegisterTime(System.currentTimeMillis());
            // 加密密码
            String userPwd = user.getUserPwd();
            String encode = passwordEncoder.encode(userPwd.trim());
            user.setUserPwd(encode);
            int i = userMapper.insertSelective(user);
            if (i != 1){
                throw new ServiceException("用户注册失败");
            }
        }catch (Exception e){
            log.info("用户{}注册发生异常{}",JSONUtil.toJsonPrettyStr(userRegisterDTO),e.getMessage());
            throw new ServiceException("用户注册信息无效");
        }
    }


}
