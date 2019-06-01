package org.nix.lovedomain.service;

import cn.hutool.core.lang.Validator;
import org.nix.lovedomain.dao.business.ClassBusinessMapper;
import org.nix.lovedomain.dao.model.ClassModel;
import org.nix.lovedomain.service.dto.ClassUpdateDto;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.SQLUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Service
public class ClassService {

    @Resource
    private ClassBusinessMapper classBusinessMapper;


    public ClassModel findClassByClassCoding(String classCoding) {
        Validator.validateNotNull(classCoding, "查询课程编码不能为空");
        ClassModel classModel = new ClassModel();
        classModel.setClassCoding(classCoding);
        return classBusinessMapper.selectOne(classModel);
    }

    public PageVo<ClassModel> findClassPage(Integer page,
                                            Integer limit,
                                            String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<ClassModel> studentBySql
                = classBusinessMapper.findClassBySql(page, limit, sql);
        Long aLong = classBusinessMapper.countClassBySql(sql);
        return PageVo.<ClassModel>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(studentBySql)
                .build();

    }

    /**
     * 更新班级信息
     *
     * @param classUpdateDto
     */
    public void updateClass(ClassUpdateDto classUpdateDto) {
        Integer teacherId = classUpdateDto.getTeacherId();
        Integer professionId = classUpdateDto.getProfessionId();
        Integer id = classUpdateDto.getId();
        String classCoding = classUpdateDto.getClassCoding();
        ClassModel classModel = new ClassModel();
        classModel.setId(id);
        classModel.setClassCoding(classCoding);
        classModel.setTeacherId(teacherId);
        classModel.setProfessionId(professionId);
        classBusinessMapper.updateByPrimaryKey(classModel);
    }

}
