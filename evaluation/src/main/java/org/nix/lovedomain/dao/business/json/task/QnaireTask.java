package org.nix.lovedomain.dao.business.json.task;

import lombok.Data;
import org.nix.lovedomain.model.Publishquestionnaire;


import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师的问卷任务, 没有过期的发布问卷
 * @date 2019/4/27
 */
@Data
public class QnaireTask {

    /**
     * 正在进行中的数量
     */
    private Integer total;
    /**
     * 已经阅读的数据量
     */
    private Integer checked;
    /**
     * 未读数量
     */
    private Integer pending;
    /**
     * 已经全部完成的数量
     */
    private Integer complete;
    /**
     * 已读的问卷信息
     */
    private Set<QnaireTaskItem> checkedDetail;
    /**
     * 待阅读的问卷信息
     */
    private Set<QnaireTaskItem> pendingDetail;
    /**
     * 已经到达完成时间的问卷，老师可以通过这里面的发布问卷
     * id查询到自己的问卷分数等信息
     */
    private Set<QnaireTaskItem> completeDetail;

    public QnaireTask() {
        this.complete = 0;
        this.checked = 0;
        this.pending = 0;
    }

    /**
     * 为老师添加问卷任务，主要用来通知老师自己
     * 的问卷开始了，和配置问卷
     *
     * @param task 任务
     */
    public void addTask(QnaireTaskItem task) {
        if (pendingDetail == null) {
            pendingDetail = new HashSet<>();
        }
        pendingDetail.add(task);
    }

    /**
     * 查阅任务后就调用该方法让未读变为
     * 已经阅读
     *
     * @param task
     */
    public void checkedTask(QnaireTaskItem task) {
        if (task == null || pendingDetail == null || !pendingDetail.contains(task)) {
            return;
        }
        pendingDetail.remove(task);
        pending = pendingDetail.size();
        if (checkedDetail == null) {
            checkedDetail = new HashSet<>();
        }
        checkedDetail.add(task);
    }

    /**
     * 当发布问卷的答卷时间到达的时候
     * 定时任务将处置这些问卷信息，使用
     * 该方法将任务调剂到已完成的问卷列表中
     *
     * @param task
     */
    public void completeTask(QnaireTaskItem task) {
        if (task == null) {
            return;
        }
        if (pendingDetail.contains(task)) {
            remove2Complete(pendingDetail, task);
        }
        if (checkedDetail.contains(task)) {
            remove2Complete(checkedDetail, task);
        }
    }

    /**
     * 将列表中的数据放到完成列表中
     *
     * @param list
     * @param task
     */
    public void remove2Complete(Set<QnaireTaskItem> list, QnaireTaskItem task) {
        list.remove(task);
        if (completeDetail == null) {
            completeDetail = new HashSet<>();
        }
        completeDetail.add(task);
    }

    /**
     * 通过id查询集合中的元素
     *
     * @param itemSet
     * @param id
     * @return
     */
    public QnaireTaskItem findQnaireTaskItemById(Set<QnaireTaskItem> itemSet, Integer id) {
        if (itemSet == null || id == null) {
            return null;
        }
        for (QnaireTaskItem item : itemSet) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 发现待查阅的问卷
     * @param id
     * @return
     */
    public QnaireTaskItem findPendingQnaireTaskItem(Integer id) {
        return findQnaireTaskItemById(pendingDetail, id);
    }

    public QnaireTaskItem findCheckedQnaireTaskItem(Integer id) {
        return findQnaireTaskItemById(checkedDetail, id);
    }

    public QnaireTaskItem findCompleteQnaireTaskItem(Integer id) {
        return findQnaireTaskItemById(completeDetail, id);
    }

    /**
     * 获取问卷总量
     *
     * @return
     */
    public Integer getTotal() {
        return checked + pending + complete;
    }

    public Integer getChecked() {
        if (checkedDetail == null) {
            return 0;
        }
        return checkedDetail.size();
    }

    public Integer getPending() {
        if (pendingDetail == null) {
            return 0;
        }
        return pendingDetail.size();
    }

    public Integer getComplete() {
        if (completeDetail == null) {
            return 0;
        }
        return completeDetail.size();
    }
}
