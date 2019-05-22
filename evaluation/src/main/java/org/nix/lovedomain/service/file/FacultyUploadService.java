package org.nix.lovedomain.service.file;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * @author zhangpei
 * @version 1.0
 * @description 管理员通过含有学院信息的excel来批量将信息录入到系统中
 * @date 2019/5/22
 */
@Service
public class FacultyUploadService {

    @Resource
    private CommonService commonService;

    public void insertFaculty2DB(InputStream facultyFile){

    }

}
