package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.TeacherCourseModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师课程业务类
 * @date 2019/5/12
 */
public interface TeacherCourseBusinessMapper extends BaseBusinessMapper<TeacherCourseModel> {


    /**
     * 查询学生的教学任务信息，按课程结束时间倒序排序
     *
     * @param offset    数据偏移量
     * @param limit     查询数量
     * @param accountId 学生账号id
     * @param year      学年
     * @param semester  学期
     * @return 教学任务
     */
    List<TeacherCourseModel> findStudentTeachTaskPage(@Param(value = "offset") Integer offset,
                                                      @Param(value = "limit") Integer limit,
                                                      @Param(value = "accountId") Integer accountId,
                                                      @Param(value = "schoolYear") Integer year,
                                                      @Param(value = "semester") String semester);


    /**
     * 查询学生的教学任务信息，获取数量
     *
     * @param accountId 学生账号id
     * @param year      学年
     * @param semester  学期
     * @return 教学任务
     */
    Long findStudentTeachTaskCount(
            @Param(value = "accountId") Integer accountId,
            @Param(value = "schoolYear") Integer year,
            @Param(value = "semester") String semester);


    /**
     * 查询老师的教学任务信息，按课程结束时间倒序排序
     *
     * @param offset    数据偏移量
     * @param limit     数量
     * @param accountId 授课老师的账号id
     * @param year      学年
     * @param semester  学期
     * @return 教学任务
     */
    List<TeacherCourseModel> findTeacherTeachTaskPage(@Param(value = "offset") Integer offset,
                                                      @Param(value = "limit") Integer limit,
                                                      @Param(value = "accountId") Integer accountId,
                                                      @Param(value = "schoolYear") Integer year,
                                                      @Param(value = "semester") String semester);

    /**
     * 查询老师的教学任务信息，获取数量
     *
     * @param accountId 学生账号id
     * @param year      学年
     * @param semester  学期
     * @return 教学任务
     */
    Long findTeacherTeachTaskCount(
            @Param(value = "accountId") Integer accountId,
            @Param(value = "schoolYear") Integer year,
            @Param(value = "semester") String semester);


    /**
     * 在所有教学任务中查询教学任务信息
     *
     * @param offset   数据偏移量
     * @param limit    数据数量
     * @param year     学年
     * @param semester 学期
     * @return 教学任务
     */
    List<TeacherCourseModel> findAllTeachTaskPage(@Param(value = "offset") Integer offset,
                                                  @Param(value = "limit") Integer limit,
                                                  @Param(value = "schoolYear") Integer year,
                                                  @Param(value = "semester") String semester);

    /**
     * 查询所有的教学任务信息，获取数量
     *
     * @param year      学年
     * @param semester  学期
     * @return 教学任务
     */
    Long findAllTeachTaskCount(
            @Param(value = "schoolYear") Integer year,
            @Param(value = "semester") String semester);

}
