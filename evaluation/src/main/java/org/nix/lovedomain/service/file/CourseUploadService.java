package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.CourseBusinessMapper;
import org.nix.lovedomain.dao.model.CourseModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @description 上传课程信息
 * @date 2019/5/22
 */
@Slf4j
@Service
public class CourseUploadService {

    @Resource
    private CommonService commonService;

    @Resource
    private CourseBusinessMapper courseBusinessMapper;

    public void insertCourseInfo(String filePath) {
        ExcelReader reader = ExcelUtil.getReader(filePath);
        List<CourseModel> all = reader.readAll(CourseModel.class);
        HashSet<CourseModel> courseModels = CollUtil.newHashSet(all);
        all = CollUtil.newArrayList(courseModels);
        int number = courseBusinessMapper.insertList(all);
        log.info("上传了{}课程", number);
    }

}
