package org.nix.zhangpei.love.recording.dao.mapper;

import org.nix.zhangpei.love.recording.dao.po.UserPO;
import org.nix.zhangpei.love.recording.dao.tx.CommentMapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
@Repository
public interface MessageBoardMapper extends CommentMapper<UserPO> {
}
