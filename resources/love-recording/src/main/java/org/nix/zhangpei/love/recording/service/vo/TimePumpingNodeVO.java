package org.nix.zhangpei.love.recording.service.vo;

import org.nix.zhangpei.love.recording.dao.po.TimePumpingNodePO;
import org.nix.zhangpei.love.recording.service.vo.base.BaseVo;

/**
 * 时间抽
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class TimePumpingNodeVO extends BaseVo {

    /**
     * 作者
     */
    private UserVO writer;
    /**
     * 消息体
     */
    private String body;
    /**
     * 题目
     */
    private String title;
    /**
     * 记录的时间
     */
    private Long recordingTime;

    public TimePumpingNodeVO(TimePumpingNodePO timePumping) {
        writer = new UserVO(timePumping.getWriter());
        body = timePumping.getBody();
        title = timePumping.getTitle();
        recordingTime = timePumping.getRecordingTime();
        setBaseVO(timePumping.getBasePO());
    }

    public UserVO getWriter() {
        return writer;
    }

    public void setWriter(UserVO writer) {
        this.writer = writer;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(Long recordingTime) {
        this.recordingTime = recordingTime;
    }

    @Override
    public String toString() {
        return "TimePumpingVO{" +
                "writer=" + writer +
                ", body='" + body + '\'' +
                ", title='" + title + '\'' +
                ", recordingTime=" + recordingTime +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
