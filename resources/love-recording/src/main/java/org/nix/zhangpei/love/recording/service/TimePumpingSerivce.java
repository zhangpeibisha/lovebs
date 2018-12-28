package org.nix.zhangpei.love.recording.service;

import org.nix.zhangpei.love.recording.dao.po.TimePumpingNodePO;
import org.nix.zhangpei.love.recording.service.tools.Page;
import org.nix.zhangpei.love.recording.service.vo.TimePumpingNodeVO;

import java.util.List;

/**
 * 时间轴服务
 * 1. 用户添加时间轴信息
 * 2. 用户查看自己写的时间轴信息
 * 3. 用户修改自己写的时间轴信息
 * 4. 用户查看全部用户写的时间轴信息
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class TimePumpingSerivce {

    /**
     * 通过数据库id查询到时间轴节点详细信息
     *
     * @param id 数据库id
     * @return 时间轴节点详细信息
     */
    public TimePumpingNodeVO findTimePumpingNodeById(Long id) {
        return null;
    }

    /**
     * 用户写一个时间节点
     *
     * @param timePumping 时间节点信息
     * @param userId      用户id
     */
    private void wireterTimePumpingNode(Long userId, TimePumpingNodeVO timePumping) {

    }

    /**
     * 用户修改自己写的时间轴节点的信息体信息
     *
     * @param userId            用户id
     * @param timePumpingNodeId 时间轴节点id
     * @param body              时间轴节点描述信息
     */
    private void updateTimePumpingNode(Long userId, Long timePumpingNodeId, String body) {

    }

    /**
     * 用户写的时间节点信息的分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页大小
     * @param userId   用户id
     * @return 分页信息
     */
    public Page<TimePumpingNodeVO> findUserTimePumpingNodePage(Long pageNum,
                                                               Long pageSize,
                                                               Long userId) {
        return null;
    }

    /**
     * 用户写的时间节点信息的分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页大小
     * @return 分页信息
     */
    public Page<TimePumpingNodeVO> findAllTimePumpingNodePage(Long pageNum,
                                                           Long pageSize) {
        return null;
    }

    /**
     * 分页查询TimePumpingNode的信息
     * 注意：
     * 1. 如果没有开始时间则按最小时间开始/ 如果开始时间大于结束时间按全局查询
     * 2. 如果没有结束时间则按最大时间结束
     * 3. 如果没有页码或者没有页码大小则全局查询
     * 4. 如果没有用户id则查询全部用户的
     *
     * @param startTime 时间轴开始时间
     * @param endTime   时间轴结束时间
     * @param pageNum   当前页码
     * @param pageSize  页码大小/页码需要多少行数据
     * @param userId    用户id
     * @return 分页查询TimePumpingNode的信息
     */
    public Page<TimePumpingNodeVO> findTimePumpingNodePage(Long startTime,
                                                           Long endTime,
                                                           Long pageNum,
                                                           Long pageSize,
                                                           Long userId) {

        return null;
    }

}
