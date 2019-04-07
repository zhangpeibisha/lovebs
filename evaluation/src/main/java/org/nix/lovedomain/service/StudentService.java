package org.nix.lovedomain.service;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.mapper.StudentMapper;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.model.StudentExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生服务提供
 * @date 2019/4/7
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public List<Student> studentList(){
        StudentExample example = new StudentExample();



        List<Student> students = studentMapper.selectByExample(example);
        return null;
    }

}
