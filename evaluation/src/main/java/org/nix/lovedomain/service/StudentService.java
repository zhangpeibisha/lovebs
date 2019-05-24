package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.json.JSONUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.AccountBusinessMapper;
import org.nix.lovedomain.dao.business.AccountRoleBusinessMapper;
import org.nix.lovedomain.dao.business.RoleBusinessMapper;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.json.student.StudentTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.dao.model.StudentModel;
import org.nix.lovedomain.service.vo.*;
import org.nix.lovedomain.utils.ListUtils;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private AccountBusinessMapper accountBusinessMapper;

    @Resource
    private RoleBusinessMapper roleBusinessMapper;

    @Resource
    private StudentService studentService;

    @Resource
    private AccountRoleBusinessMapper accountRoleBusinessMapper;

    /**
     * 分页查询简约学生信息,后台使用
     *
     * @param pageInquire 查询参数
     * @return 查询到的学生列表
     */
    public PageVo<StudentModel> studentSimpleList(StudentPageInquire pageInquire) {
        List<StudentModel> studentPage = studentBusinessMapper.findStudentPage(pageInquire);
        long studentCount = studentBusinessMapper.findStudentCount(pageInquire);
        Integer limit = pageInquire.getLimit();
        Integer page = pageInquire.getPage();
        return PageVo.<StudentModel>builder()
                .data(studentPage)
                .limit(limit == null ? (int) studentCount : limit)
                .page(page == null ? 1 : page)
                .total(studentCount)
                .build();
    }


    /**
     * 删除学生信息
     *
     * @param studentIds
     */
    public void deleteStudent(List<Integer> studentIds) {

    }

    /**
     * 老师为学生创建账号，默认密码为学号
     *
     * @param students
     */
    public void registerStudent(List<StudentModel> students) {
        Validator.validateNotNull(students, "添加的学生为空");
        students.forEach(this::createAccountToStudent);
    }

    /**
     * 为学生创建一个账户
     *
     * @param student 学生信息
     * @return 学生账号
     */
    private AccountModel createAccountToStudent(StudentModel student) {
        String studentId = student.getStudentId();
        String phone = student.getPhone();
        String email = student.getEmail();

        AccountModel accountModel = new AccountModel();
        accountModel.setEmail(email);
        accountModel.setNumbering(studentId);
        accountModel.setPhone(phone);
        accountModel.setPassword(studentId);

        accountBusinessMapper.insertSelective(accountModel);
        student.setAccountId(accountModel.getId());

        studentBusinessMapper.insertSelective(student);

        return accountModel;
    }


    /**
     * 为学生添加评教卷回答任务
     *
     * @param publishQuestionnaireModel
     */
    public void addPublishQuestionTask(PublishQuestionnaireModel publishQuestionnaireModel) {
        Integer publishId = publishQuestionnaireModel.getId();
        Date endTime = publishQuestionnaireModel.getEndRespondTime();
        for (StudentModel student : findPublishStudent(publishQuestionnaireModel)) {
            StudentTask studentTask = StudentTask.str2Bean(student);
            QnaireTask qnaireTask = studentTask.getQnaireTask();
            if (qnaireTask == null) {
                qnaireTask = new QnaireTask();
            }
            qnaireTask.addTask(new QnaireTaskItem(publishId, endTime));
            studentTask.setQnaireTask(qnaireTask);
            student.setTask(JSONUtil.toJsonStr(studentTask));
            studentBusinessMapper.updateByPrimaryKey(student);
        }
    }

    /**
     * 发现这次评教卷中的所有学生
     *
     * @param publishquestionnaire
     * @return
     */
    public List<StudentModel> findPublishStudent(PublishQuestionnaireModel publishquestionnaire) {
        PublishAttachInfo bean = PublishAttachInfo.getBean(publishquestionnaire);
        List<StudentVo> students = bean.getStudents();
        if (CollUtil.isEmpty(students)) {
            return null;
        }
        List<Integer> studentIds = new ArrayList<>(students.size());
        for (StudentVo studentVo : students) {
            if (studentVo != null) {
                studentIds.add(studentVo.getId());
            }
        }
        if (CollUtil.isEmpty(studentIds)) {
            return null;
        }
        return studentBusinessMapper.selectByIds(ListUtils.lsitIdsToString(studentIds));
    }

    /**
     * 将学生任务移到完成集合中去
     *
     * @param publishQuestionnaireModel
     */
    public void removePublishQuestionTask(PublishQuestionnaireModel publishQuestionnaireModel) {
        Integer publishId = publishQuestionnaireModel.getId();
        Date endTime = publishQuestionnaireModel.getEndRespondTime();
        for (StudentModel student : findPublishStudent(publishQuestionnaireModel)) {
            StudentTask studentTask = StudentTask.str2Bean(student);
            QnaireTask qnaireTask = studentTask.getQnaireTask();
            qnaireTask.completeTask(new QnaireTaskItem(publishId, endTime));
            studentTask.setQnaireTask(qnaireTask);
            student.setTask(JSONUtil.toJsonStr(studentTask));
            studentBusinessMapper.updateByPrimaryKey(student);
        }
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
     * //TODO 需要修改
     *
     * @param teacherAccountId 老师id
     * @param courseId         课程id
     * @return
     */
    public List<StudentModel> getStudentByTeachCourse(Integer teacherAccountId, Integer courseId) {
        return studentBusinessMapper.getStudentByTeachCourse(teacherAccountId, courseId);
    }

}
