package org.nix.lovedomain.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.nix.lovedomain.dao.mapper.base.BaseMapper;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.model.StudentExample;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 根据课程读取所有的学生
     * @param teacherId 老师id
     * @param courseId 课程id
     * @return
     */
    public List<Student> getStudentByCourse(@Param("teacherId") Integer teacherId,@Param("courseId") Integer courseId);

    /**
     * 将用户的任务写回数据库
     * @param students
     */
    public void writeStudentTask(@Param("students") List<Student> students);

    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    
}