package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.nix.lovedomain.dao.business.ClassBusinessMapper;
import org.nix.lovedomain.dao.business.FacultyBusinessMapper;
import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.*;
import org.nix.lovedomain.service.StudentService;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.service.file.model.*;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @author zhangpei
 * @version 1.0
 * @description 上传学校组织信息
 * @date 2019/5/22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrganizationService {

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherBusinessMapper teacherBusinessMapper;

    @Resource
    private ProfessionBusinessMapper professionBusinessMapper;

    @Resource
    private ClassBusinessMapper classBusinessMapper;

    @Resource
    private FacultyBusinessMapper facultyBusinessMapper;

    /**
     * 读取一个excel文件
     *
     * @param file 文件流
     * @param type 数据转换的类型
     * @param <T>  评教卷中存储的评教卷类型
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


    /**
     * 通过excel导入学院信息
     *
     * @param path
     */
    public void insertFaculty(InputStream path) {
        List<FacultyExcel> facultyExcels = readExcel2Bean(path, FacultyExcel.class);
        if (CollUtil.isEmpty(facultyExcels)) {
            return;
        }
        List<FacultyModel> facultyModels = new ArrayList<>(facultyExcels.size());
        facultyExcels.forEach(facultyExcel -> facultyModels.add(createFaculty(facultyExcel)));
        facultyBusinessMapper.insertList(facultyModels);
    }

    /**
     * 创建一个学院对象出来
     *
     * @param facultyExcel
     * @return 学院对象
     */
    public FacultyModel createFaculty(FacultyExcel facultyExcel) {
        FacultyModel facultyModel = new FacultyModel();
        String facultyId = facultyExcel.getFacultyId();
        String facultyName = facultyExcel.getFacultyName();
        facultyModel.setCoding(facultyId);
        facultyModel.setName(facultyName);
        return facultyModel;
    }

    /**
     * 通过学院名字发现学院信息
     *
     * @param facultyName
     * @return
     */
    public FacultyModel findFacultyByName(String facultyName) {
        FacultyModel facultyModel = new FacultyModel();
        facultyModel.setName(facultyName);
        List<FacultyModel> facultyModels = facultyBusinessMapper.select(facultyModel);
        if (CollUtil.isEmpty(facultyModels)) {
            return null;
        }
        return facultyModels.get(0);
    }

    /**
     * 通过excel导入专业信息
     *
     * @param path
     */
    public void insertProfession(InputStream path) {
        List<ProfessionExcel> professionExcels
                = readExcel2Bean(path, ProfessionExcel.class);
        List<ProfessionModel> professions = new ArrayList<>();
        professionExcels.forEach(professionExcel -> professions.add(createProfession(professionExcel)));
        professionBusinessMapper.insertList(professions);
    }

    /**
     * 创建专业信息
     *
     * @param professionExcel
     * @return
     */
    public ProfessionModel createProfession(ProfessionExcel professionExcel) {
        String professionCoding = professionExcel.getProfessionId();
        String professionName = professionExcel.getProfessionName();
        FacultyModel facultyByName = findFacultyByName(professionExcel.getFacultyName());
        ProfessionModel profession = new ProfessionModel();
        profession.setName(professionName);
        profession.setCoding(professionCoding);
        if (facultyByName != null) {
            profession.setFacultyId(facultyByName.getId());
        }
        return profession;
    }


    /**
     * 通过专业名字查询到专业信息
     *
     * @param professionName
     * @return
     */
    public ProfessionModel findProfessionByName(String professionName) {
        ProfessionModel profession = new ProfessionModel();
        profession.setName(professionName);
        List<ProfessionModel> select = professionBusinessMapper.select(profession);
        if (!CollUtil.isEmpty(select)) {
            return select.get(0);
        }
        return null;
    }


    /**
     * 通过excel导入班级信息
     *
     * @param path
     */
    public void insertClass(InputStream path) {
        List<ClassExcel> professionExcels
                = readExcel2Bean(path, ClassExcel.class);
        List<ClassModel> classModels = new ArrayList<>();
        professionExcels.forEach(classExcel -> classModels.add(createClassModel(classExcel)));
        classBusinessMapper.insertList(classModels);
    }

    /**
     * 创建一个班级
     *
     * @param classExcel
     * @return 班级信息
     */
    public ClassModel createClassModel(ClassExcel classExcel) {
        String classCoding = classExcel.getClassId();
        String professionName = classExcel.getProfessionName();

        ProfessionModel professionByName = findProfessionByName(professionName);
        ClassModel classModel = new ClassModel();
        classModel.setClassCoding(classCoding);
        if (professionByName == null) {
            return classModel;
        }
        classModel.setProfessionId(professionByName.getId());
        return classModel;
    }

    /**
     * 通过学校给班级的编码找到这个班级
     *
     * @param coding 班级编码
     * @return 班级信息
     */
    public ClassModel findClassByCoding(String coding) {
        ClassModel classModel = new ClassModel();
        classModel.setClassCoding(coding);
        List<ClassModel> classModels = classBusinessMapper.select(classModel);
        if (CollUtil.isEmpty(classModels)) {
            return null;
        }
        return classModels.get(0);
    }

    /**
     * 通过excel添加老师信息
     *
     * @param path
     */
    @Async
    public void insertTeacher(InputStream path) {
        List<TeacherExcel> all = readExcel2Bean(path, TeacherExcel.class);
        all.forEach(this::createTeacher);
    }

    /**
     * 根据获取到的老师信息创建一个老师账号
     *
     * @param teacherExcel 老师信息
     */
    public void createTeacher(TeacherExcel teacherExcel) {
        CreateTeacherDto createTeacherDto = new CreateTeacherDto();
        Random random = new Random();
        createTeacherDto.setPhone(random.nextInt(1000000000) + "");
        String teacherName = teacherExcel.getTeacherName();
        createTeacherDto.setName(teacherName);
        createTeacherDto.setJobNumber("" + random.nextInt(1000000000));
        createTeacherDto.setEmail(StrUtil.format("{}@163.com", teacherName));

        String professionName = teacherExcel.getProfessionName();
        ProfessionModel professionModel = findProfessionByName(professionName);

        // 如果专业存在则把老师分配到这个专业里面去
        if (Validator.isNotNull(professionModel)) {
            Integer profession = professionModel.getId();
            createTeacherDto.setProfessionId(profession);
        }

        teacherService.createTeacher(createTeacherDto);
    }

    /**
     * 通过老师名字找到老师
     *
     * @param teacherName 老师名字
     * @return 老师信息
     */
    public TeacherModel findTeacherModelByName(String teacherName) {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setName(teacherName);
        if (StrUtil.isEmpty(teacherName)){
            return null;
        }
        return teacherBusinessMapper.selectOne(teacherModel);
    }

    /**
     * excel导入班级信息为班级添加老师
     *
     * @param path
     */
    public void classInsertTeacher(InputStream path) {
        List<ClassExcel> classExcels = readExcel2Bean(path, ClassExcel.class);
        classExcels.forEach(this::classInsertTeacher);
    }


    /**
     * 为班级添加老师
     *
     * @param classExcel 班级在excel中的信息
     */
    public void classInsertTeacher(ClassExcel classExcel) {
        String classId = classExcel.getClassId();
        String teacherName = classExcel.getTeacherName();
        TeacherModel teacherModel = findTeacherModelByName(teacherName);
        ClassModel classByCoding = findClassByCoding(classId);
        if (teacherModel == null || classByCoding == null) {
            return;
        }
        classByCoding.setTeacherId(teacherModel.getAccountId());
        classBusinessMapper.updateByPrimaryKey(classByCoding);
    }


    /**
     * excel导入专业老师信息，并为该专业所属学院添加领导
     *
     * @param path 文件
     */
    public void professionInsertTeacher(InputStream path) {
        List<ProfessionExcel> professionExcels = readExcel2Bean(path, ProfessionExcel.class);
        if (CollUtil.isEmpty(professionExcels)) {
            return;
        }
        professionExcels.forEach(this::professionInsertTeacher);
    }

    /**
     * 为专业添加系主任
     *
     * @param professionExcel
     */
    public void professionInsertTeacher(ProfessionExcel professionExcel) {
        String teacherName = professionExcel.getTeacherName();
        TeacherModel teacherModelByName = findTeacherModelByName(teacherName);
        ProfessionModel professionModel
                = findProfessionByName(professionExcel.getProfessionName());
        if (teacherModelByName == null || professionModel == null) {
            return;
        }
        facultyInsertTeacher(professionExcel);
        professionModel.setDepartmentId(teacherModelByName.getAccountId());
        professionBusinessMapper.updateByPrimaryKey(professionModel);
    }

    /**
     * 为学院添加老师
     * 通过专业信息给学院添加老师、因为现有数据不全，只能如此代替
     *
     * @param professionExcel 从excel导入的专业信息
     */
    public void facultyInsertTeacher(ProfessionExcel professionExcel) {
        String teacherName = professionExcel.getTeacherName();
        TeacherModel teacherModel = findTeacherModelByName(teacherName);
        ProfessionModel professionModel
                = findProfessionByName(professionExcel.getProfessionName());
        FacultyModel facultyModel
                = facultyBusinessMapper.selectByPrimaryKey(professionModel.getFacultyId());
        facultyModel.setDean(teacherModel.getAccountId());
        facultyBusinessMapper.updateByPrimaryKeySelective(facultyModel);
    }


    @Resource
    private StudentService studentService;

    /**
     * 批量为所有班级导入模拟学生
     *
     * @param path
     */
    @Async
    public void insertStudent(InputStream path) {
        List<StudentExcel> studentExcels
                = readExcel2Bean(path, StudentExcel.class);
        Validator.validateNotNull(studentExcels, "导入模拟学生的信息为空");
        studentExcels.forEach(this::simulationStudent);
    }

    /**
     * 为一个班级模拟生成学生
     *
     * @param studentExcel
     */
    public void simulationStudent(StudentExcel studentExcel) {
        String classCoding = studentExcel.getClassId();
        String studentNumber = studentExcel.getStudentNumber();

        // 找到班级
        ClassModel classModel = findClassByClassCoding(classCoding);
        Integer professionId = classModel.getProfessionId();

        // 找到专业
        ProfessionModel professionModel
                = professionBusinessMapper.selectByPrimaryKey(professionId);
        FacultyModel facultyModel = new FacultyModel();
        if (professionModel != null) {
            // 找到学院
            Integer facultyId = professionModel.getFacultyId();
            facultyModel = facultyBusinessMapper.selectByPrimaryKey(facultyId);
        } else {
            professionModel = new ProfessionModel();
        }
        // 创建学生信息
        int number = Integer.parseInt(studentNumber);
        List<StudentModel> studentModels = new ArrayList<>(number);
        for (int i = 1; i < number + 1; i++) {
            String studentId = createStudentId(classCoding, i);
            StudentModel studentModel = new StudentModel();
            studentModel.setEmail(StrUtil.format("{}@163.com", studentId));
            studentModel.setPhone(studentId);
            studentModel.setClassId(classModel.getId());
            studentModel.setProfessionId(professionModel.getId());
            studentModel.setFacultyId(facultyModel.getId());
            studentModel.setName(studentId);
            studentModel.setStudentId(studentId);

            studentModels.add(studentModel);
        }
        studentService.registerStudent(studentModels);
    }

    /**
     * 创建学号
     *
     * @param classCoding 班级编号
     * @param number      当前学生数量
     * @return 学生编号
     */
    public String createStudentId(String classCoding, int number) {
        String studentCoding;
        if (number < 10) {
            studentCoding = "0" + number;
        } else {
            studentCoding = number + "";
        }
        return classCoding + studentCoding;
    }


    /**
     * 通过一个班级的编码找到这个班级的信息
     *
     * @param classCoding 班级在学校的编码
     * @return 班级信息
     */
    public ClassModel findClassByClassCoding(String classCoding) {
        ClassModel classModel = new ClassModel();
        classModel.setClassCoding(classCoding);
        return classBusinessMapper.selectOne(classModel);
    }

}
