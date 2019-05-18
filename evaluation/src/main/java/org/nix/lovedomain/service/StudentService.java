package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.json.student.StudentTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.dao.mapper.AccountMapper;
import org.nix.lovedomain.dao.mapper.AccountRoleMapper;
import org.nix.lovedomain.dao.mapper.RoleMapper;
import org.nix.lovedomain.dao.mapper.StudentMapper;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.vo.*;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生服务提供
 * @date 2019/4/7
 */
@Slf4j
@Getter
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private StudentService studentService;

    @Resource
    private AccountRoleMapper accountRoleMapper;

    /**
     * 分页查询简约学生信息,后台使用
     *
     * @param pageInquire 查询参数
     * @return 查询到的学生列表
     */
    public PageVo<Student> studentSimpleList(StudentPageInquire pageInquire) {
        List<Student> studentPage = studentBusinessMapper.findStudentPage(pageInquire);
        long studentCount = studentBusinessMapper.findStudentCount(pageInquire);
        Integer limit = pageInquire.getLimit();
        Integer page = pageInquire.getPage();
        return PageVo.<Student>builder()
                .data(studentPage)
                .limit(limit == null ? (int) studentCount : limit)
                .page(page == null ? 1 : page)
                .total(studentCount)
                .build();
    }

    /**
     * 更新学生信息
     *
     * @param student
     */
    public void updateStudent(Student student) {
        if (student == null) {
            return;
        }
        int i = studentMapper.updateByPrimaryKey(student);
        if (i <= 0) {
            throw new ServiceException(LogUtil.logInfo(log, "更新学生{}信息错误：{}", JSONUtil.toJsonStr(student), i));
        }
    }

    /**
     * 删除学生信息
     *
     * @param studentIds
     */
    public void delteStudent(List<Integer> studentIds) {
        if (CollUtil.isEmpty(studentIds)) {
            return;
        }
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIdIn(studentIds);
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (CollUtil.isEmpty(students)) {
            return;
        }
        // 首先删除学生的账户信息
        List<Integer> accountIds = new ArrayList<>();
        for (Student student : students) {
            accountIds.add(student.getAccountid());
        }
        int size = students.size();
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andIdIn(accountIds);
        Integer deletes = accountMapper.deleteByExample(accountExample);
        if (deletes != size) {
            throw new ServiceException(LogUtil.logWarn(log, "删除学生{}集合失败：delete={}  complete={}",
                    JSONUtil.toJsonStr(studentIds), deletes, size));
        }
        // 删除学生信息
        StudentExample deleteStudent = new StudentExample();
        deleteStudent.createCriteria().andIdIn(studentIds);
        studentMapper.deleteByExample(deleteStudent);
    }

    /**
     * 老师为学生创建账号，默认密码为学号
     *
     * @param students
     */
    public void registerStudent(List<Student> students) {
        if (CollUtil.isEmpty(students)) {
            return;
        }
        for (Student student : students) {
            try {
                Account accountToStudent = createAccountToStudent(student);
                if (accountToStudent == null) {
                    return;
                }
                student.setAccountid(accountToStudent.getId());
                studentMapper.insertSelective(student);
            } catch (Exception e) {
                String logInfo = LogUtil.logInfo(log, "添加学生{}失败：{}",
                        JSONUtil.toJsonStr(student), e.getMessage());
                throw new ServiceException(logInfo);
            }
        }
    }

    /**
     * 为学生创建一个账户
     *
     * @param student 学生信息
     * @return 学生账号
     */
    private Account createAccountToStudent(Student student) {
        if (student == null) {
            return null;
        }
        Account account = new Account();
        account.setPhone(student.getPhone());
        account.setNumbering(student.getStudentid());
        // 默认密码未学生学号
        account.setPassword(student.getStudentid());
        account.setEmail(student.getEmail());
        studentService.getAccountMapper().insertSelective(account);
        // 设置角色
        Integer integer = checkStudentRole();
        AccountRole accountRole = new AccountRole();
        accountRole.setAccountid(account.getId());
        accountRole.setRoleid(integer);
        accountRoleMapper.insertSelective(accountRole);
        return account;
    }

    /**
     * 检查学生的角色是否存在
     *
     * @return
     */
    public Integer checkStudentRole() {
        String roleName = "在校学生";
        RoleExample example = new RoleExample();
        example.createCriteria().andNameEqualTo(roleName);
        List<Role> roles = roleMapper.selectByExample(example);
        if (CollUtil.isEmpty(roles)) {
            Role e = new Role();
            e.setName(roleName);
            roleMapper.insertSelective(e);
            return e.getId();
        }
        return roles.get(0).getId();
    }

    /**
     * 为学生添加问卷回答任务
     *
     * @param publishquestionnaire
     */
    public void addPublishQuestionTask(Publishquestionnaire publishquestionnaire) {
        PublishAttachInfo bean = PublishAttachInfo.getBean(publishquestionnaire);
        List<StudentVo> students = bean.getStudents();
        if (CollUtil.isEmpty(students)) {
            return;
        }
        List<Integer> stduentIds = new ArrayList<>(students.size());
        for (StudentVo studentVo : students) {
            if (studentVo == null) {
                continue;
            }
            stduentIds.add(studentVo.getId());
        }
        if (CollUtil.isEmpty(stduentIds)) {
            return;
        }
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIdIn(stduentIds);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        Integer publishquestionnaireId = publishquestionnaire.getId();
        Date endrespondtime = publishquestionnaire.getEndrespondtime();
        for (Student student : studentList) {
            StudentTask studentTask = StudentTask.str2Bean(student);
            QnaireTask qnaireTask = studentTask.getQnaireTask();
            if (qnaireTask == null) {
                qnaireTask = new QnaireTask();
            }
            qnaireTask.addTask(new QnaireTaskItem(publishquestionnaireId, endrespondtime));
            studentTask.setQnaireTask(qnaireTask);
            student.setTask(JSONUtil.toJsonStr(studentTask));
            studentBusinessMapper.updateByPrimaryKey(student);
        }
    }

    /**
     * 将学生任务移到完成集合中去
     *
     * @param publishquestionnaire
     */
    public void removePublishQuestionTask(Publishquestionnaire publishquestionnaire) {
        PublishAttachInfo bean = PublishAttachInfo.getBean(publishquestionnaire);
        List<StudentVo> students = bean.getStudents();
        if (CollUtil.isEmpty(students)) {
            return;
        }
        List<Integer> stduentIds = new ArrayList<>(students.size());
        for (StudentVo studentVo : students) {
            if (studentVo == null) {
                continue;
            }
            stduentIds.add(studentVo.getId());
        }
        if (CollUtil.isEmpty(stduentIds)) {
            return;
        }
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andIdIn(stduentIds);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        Integer publishquestionnaireId = publishquestionnaire.getId();
        Date endrespondtime = publishquestionnaire.getEndrespondtime();
        for (Student student : studentList) {
            StudentTask studentTask = StudentTask.str2Bean(student);
            QnaireTask qnaireTask = studentTask.getQnaireTask();
            qnaireTask.completeTask(new QnaireTaskItem(publishquestionnaireId, endrespondtime));
            studentTask.setQnaireTask(qnaireTask);
            student.setTask(JSONUtil.toJsonStr(studentTask));
            studentBusinessMapper.updateByPrimaryKey(student);
        }
    }


    /**
     * 返回一个简约视图给调用者，里面没有用户的班级和账号信息
     *
     * @param pageInquire 请求参数
     * @return 查询分页列表
     */
    public PageVo<StudentVo> studentVoSimpleList(StudentPageInquire pageInquire) {
        PageVo<Student> studentPageVo = studentSimpleList(pageInquire);
        List<Student> data = studentPageVo.getData();
        if (data != null && data.size() > 0) {
            List<StudentVo> studentVos = new ArrayList<>(data.size());
            for (Student student : data) {
                studentVos.add(StudentVo.studentToSimpleStudentVo(student));
            }
            return studentPageVo.changeDataType(studentVos);
        }
        return null;
    }


    public PageVo<StudentVo> studentVODetailList(Integer page,
                                                 Integer limit,
                                                 String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<StudentVo> studentBySql
                = studentBusinessMapper.findStudentBySql(page, limit, sql);
        Long aLong = studentBusinessMapper.countStudentBySql(sql);
        return PageVo.<StudentVo>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(studentBySql)
                .build();
    }

    /**
     * 获取没有老师信息的学生信息
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    public PageVo<StudentVo> studentVODetailListNotHaveTeacher(Integer page,
                                                               Integer limit,
                                                               String sql) {
        PageVo<StudentVo> studentVoPageVo = studentVODetailList(page, limit, sql);
        List<StudentVo> data = studentVoPageVo.getData();
        if (CollUtil.isEmpty(data)) {
            return studentVoPageVo;
        }
        Iterator<StudentVo> iterator = data.iterator();
        while (iterator.hasNext()) {
            StudentVo next = iterator.next();
            next.setTask(null);
            ClassVo classzz = next.getClasszz();
            if (classzz != null) {
                classzz.setTeacher(null);
                ProfessionVo profession = classzz.getProfession();
                if (profession != null) {
                    TeacherVo teacher = profession.getTeacher();
                    teacher.setWorkJson(null);
                    FacultyVo facultyVo = profession.getFacultyVo();
                    if (facultyVo != null) {
                        facultyVo.setDean(null);
                    }
                }
            }
        }
        return studentVoPageVo;
    }

    /**
     * 根据课程读取所有的学生
     *
     * @param teacherId 老师id
     * @param courseId  课程id
     * @return
     */
    public List<Student> getStudentByCourse(Integer teacherId, Integer courseId) {
        return studentMapper.getStudentByCourse(teacherId, courseId);
    }

    /**
     * 将用户的任务写回数据库
     *
     * @param students
     */
    public void writeStudentTask(List<Student> students) {
        studentMapper.writeStudentTask(students);
    }
}
