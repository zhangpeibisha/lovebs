package org.nix.lovedomain.dao.business;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nix.lovedomain.dao.base.BaseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;

import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 课程业务
 * @date 2019/5/11
 */
public interface CourseBusinessMapper extends BaseBusinessMapper<CourseModel> {

    /**
     * 通过sql查询课程信息
     *
     * @param page
     * @param limit
     * @param sql
     * @return
     */
    @Select(value = "<script>"
            + " SELECT * FROM `course` WHERE 1=1\n" +
            "        <if test=\"sql!=null\">\n" +
            "            ${sql}\n" +
            "        </if>\n" +
            "        <if test=\"page!=null and limit!=null\">\n" +
            "            LIMIT #{page},#{limit};\n" +
            "        </if>"
            + "</script>")
    List<CourseModel> findCourseBySql(@Param(value = "page") Integer page,
                                      @Param(value = "limit") Integer limit,
                                      @Param(value = "sql") String sql);

    /**
     * 通过sql查询老师数量
     *
     * @param sql
     * @return
     */
    @Select(value = "<script>" +
            " SELECT count(*) FROM `course` WHERE 1=1\n" +
            "        <if test=\"sql!=null\">\n" +
            "            ${sql}\n" +
            "        </if>"
            + "</script>")
    Long countCourseBySql(@Param(value = "sql") String sql);

    /**
     * 通过授课id查询到课程信息
     *
     * @param teachCourseId teacher_course表里的自增主键
     * @return 课程信息
     */
    @Select(value = "SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tcourse AS c\n" +
            "LEFT JOIN teacher_course AS tc ON c.id = tc.courseId\n" +
            "WHERE\n" +
            "\ttc.id = #{teachCourseId};")
    CourseModel findCourseByTeachCourse(Integer teachCourseId);

}
