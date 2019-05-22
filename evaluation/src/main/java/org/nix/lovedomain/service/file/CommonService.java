package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.nix.lovedomain.dao.business.ClassBusinessMapper;
import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.ClassModel;
import org.nix.lovedomain.dao.model.Profession;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 上传文件通用方法
 * @date 2019/5/22
 */
@Transactional
@Service
public class CommonService {

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @Resource
    private ProfessionBusinessMapper professionBusinessMapper;

    @Resource
    private ClassBusinessMapper classBusinessMapper;

    /**
     * 读取一个excel文件
     *
     * @param file 文件流
     * @param type 数据转换的类型
     * @param <T>  问卷中存储的问卷类型
     * @return 文件中的数据list
     */
    public <T> List<T> readExcel2Bean(InputStream file, Class<T> type) {
        ExcelReader reader = ExcelUtil.getReader(file);
        return readExcel2Bean(reader, type);
    }

    public <T> List<T> readExcel2Bean(String filePath, Class<T> type) {
        ExcelReader reader = ExcelUtil.getReader(filePath);
        return readExcel2Bean(reader, type);
    }

    public <T> List<T> readExcel2Bean(ExcelReader reader, Class<T> type) {
        List<T> readAll = reader.readAll(type);
        HashSet<T> prefessionExcelHashSet = CollUtil.newHashSet(readAll);
        readAll = CollUtil.newArrayList(prefessionExcelHashSet);
        return readAll;
    }

    public void insertTeacher(String filePath) {
        List<TeacherExcel> all = readExcel2Bean(filePath, TeacherExcel.class);
        all.forEach(this::createTeacher);
    }

    public void createTeacher(TeacherExcel teacherExcel) {
        CreateTeacherDto createTeacherDto = new CreateTeacherDto();
        Random random = new Random();
        createTeacherDto.setPhone(random.nextInt(1000000000) + "");
        String teacherName = teacherExcel.getTeacherName();
        createTeacherDto.setName(teacherName);
        createTeacherDto.setJobNumber("" + random.nextInt(1000000000));
        createTeacherDto.setEmail(StrUtil.format("{}@163.com", teacherName));

        String professionName = teacherExcel.getProfessionName();
        Profession professionByName = findProfessionByName(professionName);
        Integer profession = professionByName.getId();
        createTeacherDto.setProfessionId(profession);

        teacherService.createTeacher(createTeacherDto);
    }


    @Data
    public static class TeacherExcel{
        private String teacherName;
        private String professionName;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TeacherExcel that = (TeacherExcel) o;
            return Objects.equals(teacherName, that.teacherName);
        }

        @Override
        public int hashCode() {

            return Objects.hash(teacherName);
        }
    }


    public void insertProfession(String path) {
        List<PrefessionExcel> prefessionExcels
                = readExcel2Bean(path, PrefessionExcel.class);
        List<Profession> professions = new ArrayList<>();
        prefessionExcels.forEach(prefessionExcel -> professions.add(createProfession(prefessionExcel)));
        professionBusinessMapper.insertList(professions);
    }

    public Profession createProfession(PrefessionExcel prefessionExcel) {
        String professionCoding = prefessionExcel.getProfessionCoding();
        String professionName = prefessionExcel.getProfessionName();
        String teacherName = prefessionExcel.getTeacherName();
        TeacherModel teacherModelByName = findTeacherModelByName(teacherName);
        Profession profession = new Profession();
        if (teacherModelByName != null) {
            profession.setDepartmentid(teacherModelByName.getAccountId());
        }
        profession.setName(professionName);
        profession.setCoding(professionCoding);

        return profession;
    }

    public TeacherModel findTeacherModelByName(String teacherName) {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setName(teacherName);
        List<TeacherModel> select = teacherBusinessMapper.select(teacherModel);
        if (!CollUtil.isEmpty(select)) {
            return select.get(0);
        }
        return null;
    }

    @Getter
    @Setter
    public static class PrefessionExcel {
        private String professionName;
        private String professionCoding;
        private String teacherName;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PrefessionExcel that = (PrefessionExcel) o;
            return Objects.equals(professionName, that.professionName) &&
                    Objects.equals(professionCoding, that.professionCoding);
        }

        @Override
        public int hashCode() {
            return Objects.hash(professionName, professionCoding);
        }
    }


    public void insertClass(String filePath) {
        List<ClassExcel> prefessionExcels
                = readExcel2Bean(filePath, ClassExcel.class);
        List<ClassModel> classModels = new ArrayList<>();
        prefessionExcels.forEach(new Consumer<ClassExcel>() {
            @Override
            public void accept(ClassExcel classExcel) {
                classModels.add(createClassModel(classExcel));
            }
        });
        classBusinessMapper.insertList(classModels);
    }

    public ClassModel createClassModel(ClassExcel classExcel){
        String classId = classExcel.getClassId();
        String professionName = classExcel.getProfessionName();
        String teacherName = classExcel.getTeacherName();
        TeacherModel teacherModelByName = findTeacherModelByName(teacherName);
        Profession professionByName = findProfessionByName(professionName);

        ClassModel classModel = new ClassModel();
        classModel.setClassId(classId);
        classModel.setProfessionId(professionByName.getId());
        classModel.setTeacherId(teacherModelByName.getId());
        return classModel;
    }


    public Profession findProfessionByName(String professionName) {
        Profession profession = new Profession();
        profession.setName(professionName);
        List<Profession> select = professionBusinessMapper.select(profession);
        if (!CollUtil.isEmpty(select)) {
            return select.get(0);
        }
        return null;
    }

    @Getter
    @Setter
    public static class ClassExcel {
        private String classId;
        private String teacherName;
        private String professionName;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ClassExcel that = (ClassExcel) o;
            return Objects.equals(classId, that.classId);
        }

        @Override
        public int hashCode() {

            return Objects.hash(classId);
        }
    }

}
