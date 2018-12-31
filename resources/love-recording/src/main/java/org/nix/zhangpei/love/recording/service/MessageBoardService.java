package org.nix.zhangpei.love.recording.service;

import cn.hutool.json.JSONUtil;
import org.nix.zhangpei.love.recording.controller.controller.resolver.User;
import org.nix.zhangpei.love.recording.dao.mapper.MessageBoardMapper;
import org.nix.zhangpei.love.recording.service.vo.MessageBoardVO;
import org.nix.zhangpei.love.recording.service.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 留言服务
 * 1. 用户给一个目标用户添加留言
 * 2. 用户查看别人给自己的留言，且按时间倒序排序分页展示
 * 3. 用户可以查看自己给谁留言，通过目标用户分组查询
 * 4.
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
@Service
public class MessageBoardService {

    @Resource
    private MessageBoardMapper messageBoardMapper;

    public void writerMessage(MessageBoardVO messageBoard, @User UserVO userVO) {
        System.out.println("用户信息" + JSONUtil.toJsonStr(userVO));
        // 写的信息
        String message = messageBoard.getMessage();
        // 写给谁
        UserVO reader = messageBoard.getReader();
        // 谁写的
        UserVO writer = messageBoard.getWriter();
    }


}
