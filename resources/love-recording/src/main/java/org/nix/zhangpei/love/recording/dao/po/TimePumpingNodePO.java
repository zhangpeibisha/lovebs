package org.nix.zhangpei.love.recording.dao.po;

import org.nix.zhangpei.love.recording.dao.po.base.BasePO;

/**
 * 时间抽
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/27
 */
public class TimePumpingNodePO extends BasePO {

    /**
     * 作者
     */
    private UserPO writer;
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

    public UserPO getWriter() {
        return writer;
    }

    public void setWriter(UserPO writer) {
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
        return "TimePumpingPO{" +
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
