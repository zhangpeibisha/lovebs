package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.PageUtil;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherCourseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;
import org.nix.lovedomain.dao.model.RoleModel;
import org.nix.lovedomain.dao.model.TeacherCourseModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.security.UserDetail;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.enums.SemesterEnum;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.TeachTaskVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Service
public class TeacherCourseService {


    @Resource
    private TeacherCourseBusinessMapper teacherCourseBusinessMapper;

    @Resource
    private TeacherService teacherService;

    @Resource
    private CourseBusinessMapper courseBusinessMapper;

    /**
     * 通过教学任务id查询到教学任务的详细信息
     *
     * @param teachCourseId 教学任务id
     * @return 教学任务详细信息
     */
    public TeacherCourseModel findTeachTaskByTeachCourseId(String teachCourseId) {
        TeacherCourseModel teacherCourseModel = new TeacherCourseModel();
        teacherCourseModel.setTeachCourseId(teachCourseId);
        return teacherCourseBusinessMapper.selectOne(teacherCourseModel);
    }

    /**
     * 找到用户能够查看的教学任务
     *
     * @param page         页码
     * @param limit        数量
     * @param principal    用户登陆信息
     * @param year         学年
     * @param semesterEnum 学期
     * @return 教学任务
     */
    public List<TeacherCourseModel> findUserTeachTaskList(Integer page,
                                                          Integer limit,
                                                          Principal principal,
                                                          Integer year,
                                                          SemesterEnum semesterEnum) {
        List<RoleModel> roleModels = UserDetail.analysisUserRoles(principal);
        Integer accountId = UserDetail.analysisUserAccountId(principal);
        String semesterName = null;
        if (semesterEnum != null) {
            semesterName = semesterEnum.getName();
        }
        if (page != null && limit != null){
            page = PageUtil.getStart(page, limit);
        }
        if (haveRole(RoleEnum.MANGER, roleModels)) {
            return teacherCourseBusinessMapper.findAllTeachTaskPage(page, limit, year, semesterName);
        }
        if (haveRole(RoleEnum.STUDENT, roleModels)) {
            return teacherCourseBusinessMapper.findStudentTeachTaskPage(page, limit, accountId, year, semesterName);
        }
        if (haveRole(RoleEnum.TEACHER, roleModels)) {
            return teacherCourseBusinessMapper.findTeacherTeachTaskPage(page, limit, accountId, year, semesterName);
        }
        return null;
    }


    /**
     * 找到用户能够查看的教学任务的数量
     *
     * @param principal    用户登陆信息
     * @param year         学年
     * @param semesterEnum 学期
     * @return 教学任务
     */
    public Long findUserTeachTaskCount(
            Principal principal,
            Integer year,
            SemesterEnum semesterEnum) {
        List<RoleModel> roleModels = UserDetail.analysisUserRoles(principal);
        Integer accountId = UserDetail.analysisUserAccountId(principal);
        String semesterName = null;
        if (semesterEnum != null) {
            semesterName = semesterEnum.getName();
        }
        if (haveRole(RoleEnum.MANGER, roleModels)) {
            return teacherCourseBusinessMapper.findAllTeachTaskCount(year, semesterName);
        }
        if (haveRole(RoleEnum.STUDENT, roleModels)) {
            return teacherCourseBusinessMapper.findStudentTeachTaskCount(accountId, year, semesterName);
        }
        if (haveRole(RoleEnum.TEACHER, roleModels)) {
            return teacherCourseBusinessMapper.findTeacherTeachTaskCount(accountId, year, semesterName);
        }
        return null;
    }


    public boolean haveRole(RoleEnum roleEnum, List<RoleModel> roleModels) {
        if (CollUtil.isEmpty(roleModels)) {
            return false;
        }
        for (RoleModel roleModel : roleModels) {
            if (roleEnum.getName().equals(roleModel.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取格式化教学任务信息
     *
     * @param courseModels 教学任务信息列表
     * @return 格式化的教学任务信息
     */
    public List<TeachTaskVo> teachTask2TeachTaskVo(List<TeacherCourseModel> courseModels) {
        Validator.validateNotNull(courseModels, "教学任务为空");
        List<TeachTaskVo> teachTaskVos = new ArrayList<>(courseModels.size());
        courseModels.forEach(courseModel -> {
            Integer teacherAccountId = courseModel.getTeacherAccountId();
            Integer courseId = courseModel.getCourseId();
            TeacherModel teacherModel = teacherService.findTeacherByAccountId(teacherAccountId);
            CourseModel course
                    = courseBusinessMapper.selectByPrimaryKey(courseId);
            teachTaskVos.add(TeachTaskVo.teacherCourseModel2TaskVo(courseModel, teacherModel, course));
        });
        return teachTaskVos;
    }

    /**
     * 返回分页结果给前端
     *
     * @param page         页码
     * @param limit        数量
     * @param principal    登陆用户
     * @param year         学年
     * @param semesterEnum 学期
     * @return 分页信息
     */
    public PageVo teachTaskPage(Integer page,
                                Integer limit,
                                Principal principal,
                                Integer year,
                                SemesterEnum semesterEnum) {
        List<TeachTaskVo> teachTaskVos
                = teachTask2TeachTaskVo(findUserTeachTaskList(page, limit, principal, year, semesterEnum));
        Long teachTaskCount = findUserTeachTaskCount(principal, year, semesterEnum);
        return PageVo.<TeachTaskVo>builder()
                .data(teachTaskVos)
                .total(teachTaskCount)
                .limit(limit)
                .page(page)
                .build();
    }

    /**
     * 发现用户有哪些学年
     *
     * @param principal 用户信息
     * @return 学年列表
     */
    public Set<Integer> findSchoolYearByTaskList(Principal principal) {
        List<TeacherCourseModel> teacherCourseModels
                = findUserTeachTaskList(null, null, principal, null, null);
        Validator.validateNotNull(teacherCourseModels, "没有教学任务");
        Set<Integer> years = new HashSet<>();
        teacherCourseModels.forEach(courseModel -> years.add(courseModel.getSchoolYear()));
        return years;
    }
}
