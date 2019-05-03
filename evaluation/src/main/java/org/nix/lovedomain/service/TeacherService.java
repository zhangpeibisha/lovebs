package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Slf4j
@Service
@Transactional
public class TeacherService extends BaseService<Teacher> {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private AccountMapper accountMapper;

    @Autowired
    private AccountService accountService;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    public Account findTeacherAccountById(Integer teacherId) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
        if (teacher == null) {
            return null;
        }
        Integer accountid = teacher.getAccountid();
        return accountMapper.selectByPrimaryKey(accountid);
    }

    /**
     * 通过登陆账号找到老师信息
     *
     * @param loginName 登陆名
     * @return
     */
    public Teacher findTeacherByAccountId(String loginName) {
        Account userByAccount = accountService.findUserByAccount(loginName);
        if (userByAccount == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户{}不存在", loginName));
        }
        Integer accountId = userByAccount.getId();
        TeacherExample example = new TeacherExample();
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (CollUtil.isEmpty(teachers) && teachers.size() != 1) {
            throw new ServiceException(LogUtil.logInfo(log, "用户{}不存在", loginName));
        }
        return teachers.get(0);
    }

    /**
     * 给任课老师添加问卷开始发布信息
     *
     * @param publishquestionnaire
     * @return
     */
    public Teacher addTask(Publishquestionnaire publishquestionnaire) throws Exception {
        Integer teacherByAccountId = publishquestionnaire.getTeacherid();
        Teacher teacher = findTeacherByAccountId(teacherByAccountId);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacher);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        if (qnaireTask == null) {
            qnaireTask = new QnaireTask();
        }
        qnaireTask.addTask(new QnaireTaskItem(publishquestionnaire.getId()
                , publishquestionnaire.getEndrespondtime()));

        teacherWork.setQnaireTask(qnaireTask);
        teacher.setWorkjson(JSONUtil.toJsonStr(teacherWork));
        update(teacher);
        return teacher;
    }

    /**
     * 通过老师的账号信息查询到老师的信息
     *
     * @param accountId
     * @return
     */
    public Teacher findTeacherByAccountId(Integer accountId) {
        TeacherExample releaseExample = new TeacherExample();
        releaseExample.createCriteria().andAccountidEqualTo(accountId);
        List<Teacher> teachers = teacherMapper.selectByExample(releaseExample);
        if (CollUtil.isEmpty(teachers) || teachers.size() != 1) {
            return null;
        }
        return teachers.get(0);
    }

    /**
     * 获取老师列表
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    public PageVo<Teacher> findTeacherList(Integer page,
                                           Integer limit,
                                           String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<Teacher> professionPageBySql
                = teacherBusinessMapper.findTeacherBySql(page, limit, sql);
        Long aLong = teacherBusinessMapper.countTeacherBySql(sql);

        return PageVo.<Teacher>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(professionPageBySql)
                .build();

    }

     /**
     * 问卷停止做答，改变老师任务
     * @param publishquestionnaire
     */
    public void questionnareFinish(Publishquestionnaire publishquestionnaire) throws Exception {
        Teacher teacher = findById(publishquestionnaire.getTeacherid());
        TeacherWork teacherWork = TeacherWork.str2Bean(teacher);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        qnaireTask.completeTask(publishquestionnaire.getId());
        teacher.setWorkjson(JSONUtil.toJsonStr(teacherWork));
        update(teacher);
    }

}
