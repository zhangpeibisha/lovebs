package org.nix.lovedomain.service;

import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.page.StudentPageInquire;
import org.nix.lovedomain.dao.mapper.StudentMapper;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.service.vo.StudentVo;
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

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

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


    public PageVo<StudentVo> studentVoSimpleList(StudentPageInquire pageInquire){
        PageVo<Student> studentPageVo = studentSimpleList(pageInquire);
        return null;
    }

}
