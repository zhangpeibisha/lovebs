package org.nix.lovedomain.service;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.PageUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.AccountBusinessMapper;
import org.nix.lovedomain.dao.business.AccountRoleBusinessMapper;
import org.nix.lovedomain.dao.business.RoleBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.dao.model.*;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.utils.SQLUtil;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherService {

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @Resource
    private AccountBusinessMapper accountBusinessMapper;

    @Autowired
    private AccountService accountService;

    @Resource
    private RoleBusinessMapper roleBusinessMapper;

    @Resource
    private AccountRoleBusinessMapper accountRoleBusinessMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 通过老师表里面的老师id找到老师的账号信息
     *
     * @param teacherId 老师表里面的老师id
     * @return 老师的账号信息
     */
    public AccountModel findTeacherAccountById(Integer teacherId) {
        TeacherModel teacher = teacherBusinessMapper.selectByPrimaryKey(teacherId);
        if (teacher == null) {
            return null;
        }
        Integer accountId = teacher.getAccountId();
        return accountBusinessMapper.selectByPrimaryKey(accountId);
    }

    /**
     * 通过登陆账号找到老师信息
     *
     * @param loginName 登陆名,账号表里面的信息
     * @return 老师信息
     */
    public TeacherModel findTeacherByAccountLoginName(String loginName) {
        AccountModel userByAccount = accountService.findUserByAccount(loginName);
        if (userByAccount == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户{}不存在", loginName));
        }
        Integer accountId = userByAccount.getId();
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setAccountId(accountId);
        return teacherBusinessMapper.selectOne(teacherModel);
    }

    /**
     * 给任课老师添加评教卷开始发布信息
     *
     * @param publishQuestionnaireModel 发布评教卷信息
     * @return 老师信息，已经添加了入参的发布信息
     */
    public TeacherModel addTask(PublishQuestionnaireModel publishQuestionnaireModel) throws Exception {
        Integer teacherAccountId = publishQuestionnaireModel.getTeacherAccountId();
        TeacherModel teacher = findTeacherByAccountId(teacherAccountId);
        Validator.validateNotNull(teacher, "账号id为：{}的老师不存在", teacherAccountId);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacher);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        if (qnaireTask == null) {
            qnaireTask = new QnaireTask();
        }
        qnaireTask.addTask(new QnaireTaskItem(publishQuestionnaireModel.getId()
                , publishQuestionnaireModel.getEndRespondTime()));
        teacherWork.setQnaireTask(qnaireTask);
        teacher.setWorkJson(JSONUtil.toJsonStr(teacherWork));
        teacherBusinessMapper.updateByPrimaryKey(teacher);
        return teacher;
    }

    /**
     * 将老师任务中的评教卷移到完成集合中
     *
     * @param publishQuestionnaireModel 发布评教卷信息
     * @return 老师信息，评教卷调查信息移入到结束集合中
     */
    public TeacherModel task2Complete(PublishQuestionnaireModel publishQuestionnaireModel) throws Exception {
        Integer teacherAccountId = publishQuestionnaireModel.getTeacherAccountId();
        TeacherModel teacher = findTeacherByAccountId(teacherAccountId);
        TeacherWork teacherWork = TeacherWork.str2Bean(teacher);
        QnaireTask qnaireTask = teacherWork.getQnaireTask();
        qnaireTask.completeTask(new QnaireTaskItem(publishQuestionnaireModel.getId()
                , publishQuestionnaireModel.getEndRespondTime()));
        teacherWork.setQnaireTask(qnaireTask);
        teacher.setWorkJson(JSONUtil.toJsonStr(teacherWork));
        teacherBusinessMapper.updateByPrimaryKey(teacher);
        return teacher;
    }

    /**
     * 通过老师的账号信息查询到老师的信息
     *
     * @param accountId 老师的账号id
     * @return 老师信息
     */
    public TeacherModel findTeacherByAccountId(Integer accountId) {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setAccountId(accountId);
        return teacherBusinessMapper.selectOne(teacherModel);
    }

    /**
     * 获取老师列表
     *
     * @param page  页码
     * @param limit 数量
     * @param sql   sql查询
     * @return 分页结果
     */
    public PageVo<TeacherModel> findTeacherList(Integer page,
                                                Integer limit,
                                                String sql) {
        int tempPage = PageUtil.getStart(page, limit);
        page = SQLUtil.getOffset(page, limit);
        List<TeacherModel> professionPageBySql
                = teacherBusinessMapper.findTeacherBySql(page, limit, sql);
        Long aLong = teacherBusinessMapper.countTeacherBySql(sql);

        return PageVo.<TeacherModel>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(professionPageBySql)
                .build();

    }

    /**
     * 创建一个老师
     *
     * @param dto 需要的信息
     * @return 老师信息
     */
    @Transactional(rollbackFor = Exception.class)
    public TeacherModel createTeacher(CreateTeacherDto dto) {
        String email = dto.getEmail();
        String jobNumber = dto.getJobNumber();
        String name = dto.getName();
        String phone = dto.getPhone();

        AccountModel account = new AccountModel();
        account.setPassword(passwordEncoder.encode(jobNumber));
        account.setEmail(email);
        account.setPhone(phone);
        account.setNumbering(jobNumber);
        accountBusinessMapper.insert(account);

        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setName(name);
        teacherModel.setAccountId(account.getId());
        teacherModel.setEmail(email);
        teacherModel.setPhone(phone);
        teacherModel.setJobNumber(jobNumber);
        teacherModel.setProfessionId(dto.getProfessionId());
        teacherBusinessMapper.insertSelective(teacherModel);

        AccountRoleModel accountRoleModel = new AccountRoleModel();
        accountRoleModel.setAccountId(account.getId());
        accountRoleModel.setRoleId(selectTeacherRoleNullCreate().getId());
        accountRoleBusinessMapper.insertSelective(accountRoleModel);
        
        return teacherModel;
    }


    /**
     * 创建一个老师
     *
     * @param dto 需要的信息
     * @return 老师信息
     */
    @Transactional(rollbackFor = Exception.class)
    public TeacherModel createTeacher(CreateTeacherDto dto, Integer roleId) {
        String email = dto.getEmail();
        String jobNumber = dto.getJobNumber();
        String name = dto.getName();
        String phone = dto.getPhone();

        AccountModel account = new AccountModel();
        account.setPassword(passwordEncoder.encode(jobNumber));
        account.setEmail(email);
        account.setPhone(phone);
        account.setNumbering(jobNumber);
        accountBusinessMapper.insert(account);

        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setName(name);
        teacherModel.setAccountId(account.getId());
        teacherModel.setEmail(email);
        teacherModel.setPhone(phone);
        teacherModel.setJobNumber(jobNumber);
        teacherModel.setProfessionId(dto.getProfessionId());
        teacherBusinessMapper.insertSelective(teacherModel);

        // 找到老师角色的id
        AccountRoleModel accountRoleModel = new AccountRoleModel();
        accountRoleModel.setAccountId(account.getId());
        accountRoleModel.setRoleId(roleId);
        accountRoleBusinessMapper.insertSelective(accountRoleModel);


        return teacherModel;
    }

    public RoleModel selectTeacherRoleNullCreate(){
        RoleModel roleModel = new RoleModel();
        roleModel.setName(RoleEnum.TEACHER.getName());
        RoleModel selectOne = roleBusinessMapper.selectOne(roleModel);
        if (selectOne == null) {
            roleModel.setDescription(RoleEnum.TEACHER.getDescription());
            roleBusinessMapper.insertSelective(roleModel);
            selectOne = roleModel;
        }
        return selectOne;
    }

}
