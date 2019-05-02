package org.nix.lovedomain.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.StudentBusinessMapper;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.mapper.CourseMapper;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.PublishquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.*;
import org.nix.lovedomain.service.base.BaseService;
import org.nix.lovedomain.service.vo.*;
import org.nix.lovedomain.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PublishquestionnaireService extends BaseService<Publishquestionnaire> {

    @Resource
    private StudentBusinessMapper studentBusinessMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private PublishquestionnaireMapper publishquestionnaireMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private EvaluationquestionnaireMapper evaluationquestionnaireMapper;

    @Autowired
    private TeacherService teacherService;

    @Resource
    private EvaluationquestionnaireService evaluationquestionnaireService;

    /**
     * 发布问卷
     *
     * @param principal        登陆的用户
     * @param courseId         课程id
     * @param teacherId        老师id
     * @param questionnaireId  问卷id
     * @param description      发布描述
     * @param startRespondTime 开始答卷时间-老师可以在答卷期间编辑黑名单
     * @param endRespondTime   结束答卷时间-任何人禁止修改内容，开始统计数据
     * @return 发布详情
     * @throws Exception 添加信息抛出异常
     */
    public Publishquestionnaire pusblishQuestionnaire(Principal principal,
                                                      Integer courseId,
                                                      Integer teacherId,
                                                      Integer questionnaireId,
                                                      String description,
                                                      Long startRespondTime,
                                                      Long endRespondTime,
                                                      Integer balcks) throws Exception {

        Publishquestionnaire publishquestionnaire = new Publishquestionnaire();
        publishquestionnaire.setCourseid(courseId);
        publishquestionnaire.setDescription(description);
        publishquestionnaire.setEndrespondtime(new Date(endRespondTime));
        publishquestionnaire.setStartrespondtime(new Date(startRespondTime));
        publishquestionnaire.setQuestionnaireid(questionnaireId);
        publishquestionnaire.setTeacherid(teacherId);

        String name = principal.getName();
        Account userByAccount = accountService.findUserByAccount(name);
        publishquestionnaire.setReleaseid(userByAccount.getId());

        // ==================== 下面开始填充发布问卷的附加信息 ==================

        // 根据课程id和老师id找到相应的学生id
        List<StudentVo> studentByTeacherIdAndCourseId
                = studentBusinessMapper.findStudentByTeacherIdAndCourseId(teacherId, courseId);
        int size = studentByTeacherIdAndCourseId.size();
        PublishAttachInfo publishAttachInfo = new PublishAttachInfo();
        publishAttachInfo.setPlan(size);
        publishAttachInfo.setStudents(studentByTeacherIdAndCourseId);
        publishAttachInfo.setCanFilters(balcks);

        // 设置统计信息
        publishquestionnaire.setStatistics(JSONUtil.toJsonStr(publishAttachInfo));

        // 执行保存动作
        publishquestionnaireMapper.insertSelective(publishquestionnaire);
        return publishquestionnaire;
    }

    /**
     * 添加黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    public Publishquestionnaire addBlack(Integer publisId,
                                         List<Integer> studentIds,
                                         Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        Integer id = userByAccount.getId();
        Integer teacherid = byId.getTeacherid();
        if (!id.equals(teacherid)) {
            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
        }

        bean.addBlackStudent(studentIds);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
    }

    /**
     * 删除黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    public Publishquestionnaire deleteBlack(Integer publisId,
                                            List<Integer> studentIds,
                                            Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        Integer id = userByAccount.getId();
        Integer teacherid = byId.getTeacherid();
        if (!id.equals(teacherid)) {
            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
        }
        bean.deleteBlackStudent(studentIds);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
    }

    /**
     * 提交回答信息，
     *
     * @param publisId
     * @param completesQuestion
     * @return
     */
    public Publishquestionnaire writeQuestion(Integer publisId,
                                              PublishAttachInfo.CompletesQuestion completesQuestion,
                                              Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        checkStudentHavePermissionUse(bean, userByAccount.getId());

        bean.writeQuestion(completesQuestion);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
    }

    /**
     * 更新回答，只有 status=keep的时候可以更新
     *
     * @param publisId
     * @param completesQuestion
     * @return
     */
    public Publishquestionnaire updateQuestion(Integer publisId,
                                               PublishAttachInfo.CompletesQuestion completesQuestion,
                                               Principal principal) {
        Publishquestionnaire byId = findById(publisId);
        PublishAttachInfo bean = PublishAttachInfo.getBean(byId);

        Account userByAccount = accountService.findUserByAccount(principal.getName());
        checkStudentHavePermissionUse(bean, userByAccount.getId());

        bean.updateQuestion(completesQuestion);
        byId.setStatistics(JSONUtil.toJsonStr(bean));
        publishquestionnaireMapper.updateByPrimaryKey(byId);
        return byId;
    }

    /**
     * 批量获取发布问卷信息
     *
     * @param ids
     * @return
     */
    public List<Publishquestionnaire> batchQuireQuestion(List<Integer> ids) {
        if (CollUtil.isEmpty(ids)) {
            return new ArrayList<>();
        }
        PublishquestionnaireExample example = new PublishquestionnaireExample();
        example.createCriteria().andIdIn(ids);
        return publishquestionnaireMapper.selectByExample(example);
    }

    /**
     * 发现发布问卷的详细信息
     *
     * @param ids
     * @return
     */
    public List<PublishQuestionVo> findPublishQuestionDeatil(List<Integer> ids) {
        List<Publishquestionnaire> publishquestionnaires = batchQuireQuestion(ids);
        if (CollUtil.isEmpty(publishquestionnaires)) {
            return new ArrayList<>();
        }
        List<PublishQuestionVo> result = new ArrayList<>(ids.size());
        for (Publishquestionnaire publishquestionnaire : publishquestionnaires) {
            PublishQuestionVo publishQuestionVo = findPublishQuestionVo(publishquestionnaire);
            if (publishQuestionVo == null) {
                continue;
            }
            result.add(publishQuestionVo);
        }
        return result;
    }

    /**
     * 获取发布问卷的详细信息
     *
     * @param publishquestionnaire
     * @return
     */
    public PublishQuestionVo findPublishQuestionVo(Publishquestionnaire publishquestionnaire) {
        Integer teacherid = publishquestionnaire.getTeacherid();
        Teacher teacher = teacherService.findTeacherByAccountId(teacherid);
        if (teacher == null) {
            return null;
        }
        teacher.setWorkjson(null);

        // 不显示老师的工作情况
        Integer releaseid = publishquestionnaire.getReleaseid();
        Teacher release = teacherService.findTeacherByAccountId(releaseid);
        if (release == null) {
            return null;
        }
        release.setWorkjson(null);


        Integer courseid = publishquestionnaire.getCourseid();
        Course course = courseMapper.selectByPrimaryKey(courseid);

        PublishQuestionVo publishQuestionVo = new PublishQuestionVo();
        publishQuestionVo.setTeacher(TeacherVo.teacherToSimpleTeacherVo(teacher));
        publishQuestionVo.setRelease(TeacherVo.teacherToSimpleTeacherVo(release));
        EvaluationquestionnaireSimpleVo evaluationquestionnaireSimpleVo = evaluationquestionnaireService
                .findSimpleVoById(publishquestionnaire.getQuestionnaireid());
        if (evaluationquestionnaireSimpleVo == null) {
            return null;
        }
        publishQuestionVo.setQuestionnaire(evaluationquestionnaireSimpleVo);
        publishQuestionVo.setCourse(course);
        publishQuestionVo.setDescription(publishquestionnaire.getDescription());
        publishQuestionVo.setReleaseTime(publishquestionnaire.getReleasetime());
        publishQuestionVo.setStartRespondTime(publishquestionnaire.getStartrespondtime());
        publishQuestionVo.setEndRespondTime(publishquestionnaire.getEndrespondtime());
        publishQuestionVo.setId(publishquestionnaire.getId());
        return publishQuestionVo;
    }


    public static void checkStudentHavePermissionUse(PublishAttachInfo bean, Integer id) {
        List<StudentVo> students = bean.getStudents();
        boolean flag = false;
        for (StudentVo studentVo : students) {
            if (studentVo.getId().equals(id)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new ServiceException(LogUtil.logWarn(log, "访问无效，资源所属不正确"));
        }
    }

    /**
     * 获取需要发布的所有问卷
     *
     * @return List
     */
    public List<Publishquestionnaire> getAllDataByLimit(String dateStr) {
        return publishquestionnaireMapper.getAllDataByLimit(dateStr);
    }

}
