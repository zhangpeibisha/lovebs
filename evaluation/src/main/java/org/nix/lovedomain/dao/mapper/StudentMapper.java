package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.model.StudentExample;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 根据课程读取所有的学生
     *
     * @param teacherId 老师id
     * @param courseId  课程id
     * @return
     */
    List<Student> getStudentByCourse(@Param("teacherId") Integer teacherId, @Param("courseId") Integer courseId);

    /**
     * 将用户的任务写回数据库
     *
     * @param students
     */
     void writeStudentTask(@Param("students") List<Student> students);

    List<Student> selectByExample(StudentExample studentExample);

    int deleteByExample(StudentExample example);

    int countByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * 获取所有的学生
     * @return
     */
    List<Student> selectAllStudents();

    HashMap<Integer,Integer> selectAllStuOfProfession();

    HashMap<Integer,Integer> selectAllStuOfFaculty();

}