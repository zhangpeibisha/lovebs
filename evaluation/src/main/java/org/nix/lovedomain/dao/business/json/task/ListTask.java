package org.nix.lovedomain.dao.business.json.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @version 1.0
 * @anthor on 2019/4/23
 * @since jdk8
 */
public class ListTask implements Serializable{


    private ArrayList<QnaireTask> list;

    public ListTask(){
        list = new ArrayList<>();
    }

    /**
     * 添加一个问卷任务
     * @param qnaireTask
     */
    public void add(QnaireTask qnaireTask){
        list.add(qnaireTask);
    }

    /**
     * 删除过期的问卷
     */
    public Integer deletePastDue(){
        Integer deleteAccount = 0;
        Date currentDate = new Date();
        for (int i = 0; i < list.size();){
            if(currentDate.after(list.get(i).getPastDue())){
                list.remove(i);
                deleteAccount++;
            }else {
                i++;
            }
        }

        return deleteAccount;

    }


    /**
     * 问卷任务类
     */
     public static class QnaireTask implements Serializable {

         // 问卷id
        private Integer id;

        // 问卷到期时间
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
}
