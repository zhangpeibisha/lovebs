package org.nix.lovedomain.service;

import cn.hutool.json.JSONUtil;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.Account;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.service.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Service
@Transactional
public class TeacherService extends BaseService<Teacher> {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private AccountMapper accountMapper;

    public Account findTeacherAccountById(Integer teacherId) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
        if (teacher == null) {
            return null;
        }
        Integer accountid = teacher.getAccountid();
        return accountMapper.selectByPrimaryKey(accountid);
    }

    /**
     * 给任课老师添加问卷开始发布信息
     *
     * @param publishquestionnaire
     * @return
     */
    public Teacher addTask(Publishquestionnaire publishquestionnaire) throws Exception {
        Integer teacherid = publishquestionnaire.getTeacherid();
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherid);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacher);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        if (qnaireTask == null) {
            qnaireTask = new QnaireTask();
            teacherWork.setQnaireTask(qnaireTask);
        }
        qnaireTask.addTask(new QnaireTaskItem(publishquestionnaire.getId()
                , publishquestionnaire.getEndrespondtime()));

        teacher.setWorkjson(JSONUtil.toJsonStr(teacherWork));
        update(teacher);
        return teacher;
    }

    /**
     * 问卷停止做答，改变老师任务
     *
     * @param publishquestionnaire
     */
    public void questionnareFinish(Publishquestionnaire publishquestionnaire) throws Exception{
        Teacher teacher = findById(publishquestionnaire.getTeacherid());
        TeacherWork teacherWork = TeacherWork.str2Bean(teacher);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        qnaireTask.completeTask(publishquestionnaire.getId());
        teacher.setWorkjson(JSONUtil.toJsonStr(teacherWork));
        update(teacher);
    }

}
