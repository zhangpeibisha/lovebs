package org.nix.lovedomain.dao.business.json.task;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 简单的发布问卷信息，用于给用提供统计使用
 * 方便查询
 *
 * @version 1.0
 * @anthor on 2019/4/24
 * @since jdk8
 */
@Data
public class QnaireTaskItem implements Serializable {
    /**
     * 发布的问卷id
     */
    private Integer id;

    /**
     * 规定的到期时间
     */
    private Date pastDue;

    public QnaireTaskItem(Integer id, Date pastDue) {
        this.id = id;
        this.pastDue = pastDue;
    }

    public Integer getId() {
        return id;
    }

    public Date getPastDue() {
        return pastDue;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPastDue(Date pastDue) {
        this.pastDue = pastDue;
    }
}
