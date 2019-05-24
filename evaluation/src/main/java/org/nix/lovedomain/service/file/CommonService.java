package org.nix.lovedomain.service.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.nix.lovedomain.dao.business.ClassBusinessMapper;
import org.nix.lovedomain.dao.business.FacultyBusinessMapper;
import org.nix.lovedomain.dao.business.ProfessionBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherBusinessMapper;
import org.nix.lovedomain.dao.model.ClassModel;
import org.nix.lovedomain.dao.model.FacultyModel;
import org.nix.lovedomain.dao.model.ProfessionModel;
import org.nix.lovedomain.dao.model.TeacherModel;
import org.nix.lovedomain.service.TeacherService;
import org.nix.lovedomain.service.file.model.ClassExcel;
import org.nix.lovedomain.service.file.model.FacultyExcel;
import org.nix.lovedomain.service.file.model.ProfessionExcel;
import org.nix.lovedomain.service.file.model.TeacherExcel;
import org.nix.lovedomain.web.controller.dto.CreateTeacherDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
     * 初始化方法
     *
     * @param path
     */
    public void insertFacultyAndProfession(String path) {
        insertFaculty(path);
        insertProfession(path);
        insertClass(path);
    }

    /**
     * 添加老师和为专业、学院、班级添加老师
     *
     * @param path 文件路径
     */
    public void fillInfo(String path) {
        insertTeacher(path);
        classInsertTeacher(path);
        professionInsertTeacher(path);
        facultyInsertTeacher(path);
    }

    /**
     * 通过excel导入学院信息
     *
     * @param path
     */
    public void insertFaculty(String path) {
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
    public void insertProfession(String path) {
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
     * @param filePath
     */
    public void insertClass(String filePath) {
        List<ClassExcel> professionExcels
                = readExcel2Bean(filePath, ClassExcel.class);
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
        String classId = classExcel.getClassId();
        String professionName = classExcel.getProfessionName();

        ProfessionModel professionByName = findProfessionByName(professionName);
        ClassModel classModel = new ClassModel();
        classModel.setClassId(classId);
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
        classModel.setClassId(coding);
        List<ClassModel> classModels = classBusinessMapper.select(classModel);
        if (CollUtil.isEmpty(classModels)) {
            return null;
        }
        return classModels.get(0);
    }

    /**
     * 通过excel添加老师信息
     *
     * @param filePath
     */
    public void insertTeacher(String filePath) {
        List<TeacherExcel> all = readExcel2Bean(filePath, TeacherExcel.class);
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
        ProfessionModel professionByName = findProfessionByName(professionName);
        Integer profession = professionByName.getId();
        createTeacherDto.setProfessionId(profession);

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
        return teacherBusinessMapper.selectOne(teacherModel);
    }

    /**
     * excel导入班级信息为班级添加老师
     *
     * @param path
     */
    public void classInsertTeacher(String path) {
        List<ClassExcel> classExcels = readExcel2Bean(path, ClassExcel.class);
        classExcels.forEach(this::classInsertTeacher);
    }


    /**
     * 为班级添加老师
     *
     * @param classExcel 班级再excel中的信息
     */
    public void classInsertTeacher(ClassExcel classExcel) {
        String classId = classExcel.getClassId();
        String teacherName = classExcel.getTeacherName();
        TeacherModel teacherModelByName = findTeacherModelByName(teacherName);
        ClassModel classByCoding = findClassByCoding(classId);
        if (teacherModelByName == null || classByCoding == null) {
            return;
        }
        classByCoding.setTeacherId(teacherModelByName.getAccountId());
        classBusinessMapper.updateByPrimaryKey(classByCoding);
    }


    /**
     * excel导入班级信息为班级添加老师
     *
     * @param path
     */
    public void professionInsertTeacher(String path) {
        List<ProfessionExcel> classExcels = readExcel2Bean(path, ProfessionExcel.class);
        classExcels.forEach(this::professionInsertTeacher);
    }

    /**
     * 为专业添加系主任
     *
     * @param professionExcel
     */
    public void professionInsertTeacher(ProfessionExcel professionExcel) {
        String teacherName = professionExcel.getTeacherName();
        TeacherModel teacherModelByName = findTeacherModelByName(teacherName);
        ProfessionModel professionByName
                = findProfessionByName(professionExcel.getProfessionName());
        if (teacherModelByName == null || professionByName == null) {
            return;
        }
        professionByName.setDepartmentId(teacherModelByName.getAccountId());
        professionBusinessMapper.updateByPrimaryKey(professionByName);
    }


    /**
     * excel导入班级信息为班级添加老师
     *
     * @param path
     */
    public void facultyInsertTeacher(String path) {
        List<FacultyExcel> classExcels = readExcel2Bean(path, FacultyExcel.class);
        classExcels.forEach(this::facultyInsertTeacher);
    }

    /**
     * 为学院添加老师
     *
     * @param facultyExcel
     */
    public void facultyInsertTeacher(FacultyExcel facultyExcel) {
        String facultyName = facultyExcel.getFacultyName();
        FacultyModel facultyByName = findFacultyByName(facultyName);
        String teacherName = facultyExcel.getTeacherName();
        TeacherModel teacherModelByName = findTeacherModelByName(teacherName);
        facultyByName.setDean(teacherModelByName.getAccountId());
        facultyBusinessMapper.updateByPrimaryKeySelective(facultyByName);
    }

}
