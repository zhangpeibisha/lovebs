package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.json.JSONUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
import org.nix.lovedomain.dao.model.*;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.*;
import org.nix.lovedomain.utils.ListUtils;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private AccountBusinessMapper accountBusinessMapper;

    @Resource
    private RoleBusinessMapper roleBusinessMapper;

    @Resource
    private StudentService studentService;

    @Resource
    private AccountRoleBusinessMapper accountRoleBusinessMapper;

    @Resource
    private ClassService classService;

    @Resource
    private TeacherCourseService teacherCourseService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 通过班级编码发现这个班级的所有学生
     *
     * @param classCoding 班级编码
     * @return 这个班级的所有学生
     */
    public List<StudentModel> findStudentModelsByClassCoding(String classCoding) {
        ClassModel classModel = classService.findClassByClassCoding(classCoding);
        Integer classModelId = classModel.getId();
        return findStudentModelsByClassId(classModelId);
    }

    /**
     * 通过学号查询到学生信息
     * @param studentId 学号
     * @return 学生信息
     */
    public StudentModel findStudentByStudentId(String studentId){
        StudentModel studentModel = new StudentModel();
        studentModel.setStudentId(studentId);
        return studentBusinessMapper.selectOne(studentModel);
    }

    /**
     * 通过班级的自增主键查询该班级的学生信息信息
     *
     * @param classId 班级自增主键
     * @return 班级信息
     */
    public List<StudentModel> findStudentModelsByClassId(Integer classId) {
        StudentModel studentModel = new StudentModel();
        studentModel.setClassId(classId);
        return studentBusinessMapper.select(studentModel);
    }

    /**
     * 老师为学生创建账号，默认密码为学号
     *
     * @param students
     */
    public void registerStudent(List<StudentModel> students) {
        Validator.validateNotNull(students, "添加的学生为空");
        for (StudentModel student : students) {
            studentService.createAccountToStudent(student);
        }
    }

    /**
     * 为学生创建一个账户
     *
     * @param student 学生信息
     * @return 学生账号
     */
    @Transactional(rollbackFor = Exception.class)
    public AccountModel createAccountToStudent(StudentModel student) {
        String studentId = student.getStudentId();
        String phone = student.getPhone();
        String email = student.getEmail();

        AccountModel accountModel = new AccountModel();
        accountModel.setEmail(email);
        accountModel.setNumbering(studentId);
        accountModel.setPhone(phone);
        accountModel.setPassword(passwordEncoder.encode(studentId));

        accountBusinessMapper.insertSelective(accountModel);
        student.setAccountId(accountModel.getId());

        studentBusinessMapper.insertSelective(student);

        // 找到学生角色的id
        RoleModel roleModel = new RoleModel();
        roleModel.setName(RoleEnum.STUDENT.getName());
        RoleModel selectOne = roleBusinessMapper.selectOne(roleModel);
        if (selectOne == null) {
            roleModel.setDescription(RoleEnum.STUDENT.getDescription());
            roleBusinessMapper.insertSelective(roleModel);
            selectOne = roleModel;
        }
        AccountRoleModel accountRoleModel = new AccountRoleModel();
        accountRoleModel.setAccountId(accountModel.getId());
        accountRoleModel.setRoleId(selectOne.getId());
        accountRoleBusinessMapper.insertSelective(accountRoleModel);

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
     * @param publishQuestionnaireModel 发布的评教卷信息
     * @return 参与这个评教卷的所有学生信息
     */
    public List<StudentModel> findPublishStudent(PublishQuestionnaireModel publishQuestionnaireModel) {
        PublishAttachInfo bean = PublishAttachInfo.getBean(publishQuestionnaireModel);
        List<Integer> students = bean.getStudents();
        return studentBusinessMapper.findStudentModelByAccountIds(students);
    }

    /**
     * 通过学生信息获取到学生的账号id
     *
     * @param studentModels 学生的信息集合
     * @return 学生的账号id
     */
    public List<Integer> findStudentAccountIdsByStudentModel(List<StudentModel> studentModels) {
        Validator.validateNotNull(studentModels, "学生信息为空");
        List<Integer> studentAccountIds = new ArrayList<>(studentModels.size());
        studentModels.forEach(studentModel -> studentAccountIds.add(studentModel.getAccountId()));
        return studentAccountIds;
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
                    if (teacher != null) {
                        teacher.setWorkJson(null);
                    }
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
