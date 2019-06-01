package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import org.nix.lovedomain.dao.business.FacultyBusinessMapper;
import org.nix.lovedomain.dao.model.FacultyModel;
import org.nix.lovedomain.dao.model.RoleModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.security.UserDetail;
import org.nix.lovedomain.service.enums.RoleEnum;
import org.nix.lovedomain.service.vo.FacultyTeacherVo;
import org.nix.lovedomain.service.vo.FacultyVo;
import org.nix.lovedomain.service.vo.PageVo;
import org.nix.lovedomain.utils.SQLUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author zhangpei
 * @version 1.0
 * @since jdk8
 */
@Service
public class FacultyService {

    @Resource
    private FacultyBusinessMapper facultyBusinessMapper;

    @Resource
    private TeacherService teacherService;

    public PageVo<FacultyTeacherVo> findFacultyPage(Integer page,
                                                    Integer limit,
                                                    String sql) {
        if (page == null) {
            page = 1;
        }
        int tempPage = page;
        page = SQLUtil.getOffset(page, limit);
        List<FacultyModel> faculty
                = facultyBusinessMapper.findFacultyBySql(page, limit, sql);
        if (CollUtil.isEmpty(faculty)) {
            return PageVo.<FacultyTeacherVo>builder()
                    .page(tempPage)
                    .limit(limit)
                    .total(0L)
                    .data(null)
                    .build();
        }
        List<FacultyTeacherVo> facultyVos = new ArrayList<>(faculty.size());
        faculty.forEach(facultyModel -> {
            FacultyTeacherVo facultyVo = new FacultyTeacherVo();
            facultyVo.setCoding(facultyModel.getCoding());
            facultyVo.setId(facultyModel.getId());
            facultyVo.setName(facultyModel.getName());
            Integer dean = facultyModel.getDean();
            if (dean != null) {
                TeacherModel teacher = teacherService.findTeacherByAccountId(dean);
                facultyVo.setDean(teacher);
            }
            facultyVos.add(facultyVo);
        });
        Long aLong = facultyBusinessMapper.countFacultyBySql(sql);
        return PageVo.<FacultyTeacherVo>builder()
                .page(tempPage)
                .limit(limit)
                .total(aLong)
                .data(facultyVos)
                .build();

    }

    /**
     * 发现用户能够查看的学院信息
     *
     * @param principal 登陆用户
     * @return 学院信息
     */
    public List<FacultyModel> findUserFaculty(Principal principal) {
        List<String> roles = UserDetail.analysisUserStrRoles(principal);
        Integer accountId = UserDetail.analysisUserAccountId(principal);
        if (roles.contains(RoleEnum.TEACHER.getName())) {
            return CollUtil.newArrayList(facultyBusinessMapper.findFaculty2TeacherByAccountId(accountId));
        }
        if (roles.contains(RoleEnum.MANGER.getName())) {
            return facultyBusinessMapper.selectAll();
        }
        return null;
    }

}
