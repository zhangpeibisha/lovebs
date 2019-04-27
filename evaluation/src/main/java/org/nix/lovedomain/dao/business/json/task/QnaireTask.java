package org.nix.lovedomain.dao.business.json.task;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @anthor on 2019/4/24
 * @since jdk8
 */
@Data
public class QnaireTask  implements Serializable {
    /**
     * 发布的问卷id
     */
    private Integer id;

    /**
     * 规定的到期时间
     */
    private Date pastDue;

    public QnaireTask(Integer id, Date pastDue) {
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
