package org.nix.lovedomain.web.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.nix.lovedomain.dao.business.EvaluationQuestionnaireBusinessMapper;
import org.nix.lovedomain.dao.business.PublishQuestionBusinessMapper;
import org.nix.lovedomain.dao.business.TeacherCourseBusinessMapper;
import org.nix.lovedomain.dao.business.json.winding.PublishAttachInfo;
import org.nix.lovedomain.dao.model.AccountModel;
import org.nix.lovedomain.dao.model.EvaluationQuestionnaireModel;
import org.nix.lovedomain.dao.model.PublishQuestionnaireModel;
import org.nix.lovedomain.dao.model.TeacherCourseModel;
import org.nix.lovedomain.service.AccountService;
import org.nix.lovedomain.service.PublishQuestionnaireService;
import org.nix.lovedomain.service.ServiceException;
import org.nix.lovedomain.service.vo.PublishQuestionJsonVo;
import org.nix.lovedomain.utils.LogUtil;
import org.nix.lovedomain.web.controller.dto.RespondsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @anthor on 2019/4/19
 * @since jdk8
 */
@Slf4j
@RestController
@Api(value = "发布评教卷控制器", description = "该控制器主要完成和发布评教卷相关的工作")
@RequestMapping(value = "publishQuestionnaire")
public class PublishQuestionnaireController {

    @Autowired
    private PublishQuestionnaireService publishquestionnaireService;

    @Resource
    private EvaluationQuestionnaireBusinessMapper evaluationQuestionnaireBusinessMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private PublishQuestionBusinessMapper publishQuestionBusinessMapper;

    /**
     * 发布评教卷
     *
     * @param principal          登陆信息
     * @param courseAndTeacherId 老师+课程的最新一条数据id
     * @param teacherId          老师id
     * @param questionnaireId    评教卷id
     * @param description        发布描述
     * @param startRespondTime   开始回答时间
     * @param endRespondTime     结束回答时间
     * @param blacks             黑名单个数
     * @return 响应信息
     * @throws Exception 异常信息
     */
    @ApiOperation(value = "发布评教评教卷")
    @PostMapping(value = "/publish")
    public RespondsMessage pusblishQuestionnaire(Principal principal,
                                                 @RequestParam(value = "courseAndTeacherId") Integer courseAndTeacherId,
                                                 @RequestParam(value = "teacherId") Integer teacherId,
                                                 @RequestParam(value = "questionnaireId") Integer questionnaireId,
                                                 @RequestParam(value = "description", required = false) String description,
                                                 @RequestParam(value = "startRespondTime") Long startRespondTime,
                                                 @RequestParam(value = "endRespondTime") Long endRespondTime,
                                                 @ApiParam(value = "发布人可以设置该任课老师可以屏蔽几个学生的成绩不计入统计")
                                                 @RequestParam(value = "blacks", defaultValue = "5") Integer blacks) throws Exception {

        Validator.validateNotNull(principal, "用户为登陆");
        PublishQuestionnaireModel publication = publishquestionnaireService.pusblishQuestionnaire(principal,
                courseAndTeacherId, teacherId, questionnaireId, description, startRespondTime, endRespondTime, blacks);

        return RespondsMessage.success(LogUtil.logInfo(log, "{}发布评教评教卷成功", principal.getName()),
                publication);
    }

    /**
     * 根据课程id批量发布评教卷
     *
     * @param principal        用户登陆信息
     * @param courseIds        课程id集合
     * @param questionnaireId  评教卷id
     * @param description      发布描述
     * @param startRespondTime 开始答卷时间
     * @param endRespondTime   结束答卷时间
     * @param blacks           黑名单数量
     * @return 响应信息
     * @throws Exception 抛出异常
     */
    @ApiOperation(value = "发布评教评教卷")
    @PostMapping(value = "/publish/by/courseIds")
    public RespondsMessage publishQuestionnaireByCourseIds(Principal principal,
                                                           @RequestParam(value = "courseIds") List<Integer> courseIds,
                                                           @RequestParam(value = "questionnaireId") Integer questionnaireId,
                                                           @RequestParam(value = "description", required = false) String description,
                                                           @RequestParam(value = "startRespondTime") Long startRespondTime,
                                                           @RequestParam(value = "endRespondTime") Long endRespondTime,
                                                           @ApiParam(value = "发布人可以设置该任课老师可以屏蔽几个学生的成绩不计入统计")
                                                           @RequestParam(value = "blacks", defaultValue = "5") Integer blacks) throws Exception {

        if (principal == null) {
            throw new ServiceException("用户未登陆");
        }
        List<TeacherCourseModel> teacherCourseInCurrSemester = findTeacherCourseInCurrSemester(courseIds);
        if (CollUtil.isEmpty(teacherCourseInCurrSemester)) {
            return RespondsMessage.failure(LogUtil.logInfo(log,
                    "发布失败，没用找到课程{}的授课老师,在当前学期", courseIds));
        }
        teacherCourseInCurrSemester.forEach(teacherCourseModel -> {
            try {
                Integer teacherAccountId = teacherCourseModel.getTeacherAccountId();
                publishquestionnaireService.pusblishQuestionnaire(principal,
                        teacherCourseModel.getId(), teacherAccountId,
                        questionnaireId, description,
                        startRespondTime,
                        endRespondTime, blacks);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return RespondsMessage.success(StrUtil.format("发布针对课程{}的评教卷成功", courseIds));
    }

    @Resource
    private TeacherCourseBusinessMapper teacherCourseBusinessMapper;

    /**
     * 通过course表中的课程id获取到所有当前学期参与授课的老师
     *
     * @param courseId 课程id集合
     * @return 老师课程信息
     */
    public List<TeacherCourseModel> findTeacherCourseInCurrSemester(List<Integer> courseId) {
        if (CollUtil.isEmpty(courseId)) {
            return null;
        }
        String currSemesterStartTime = findCurrSemesterStartTime();
        String currSemesterEndTime = findCurrSemesterEndTime();
        return teacherCourseBusinessMapper.findTeacherCourseInCurrSemester(courseId,
                currSemesterStartTime, currSemesterEndTime);
    }

    /**
     * 当前月份大于等于9，则认为是第一续期
     */
    private int september = 9;
    /**
     * 当前月份小于3，认为是第一学期
     */
    private int march = 3;


    /**
     * 获取当前学期的开始时间
     *
     * @return 当前学期的开始时间
     */
    public String findCurrSemesterStartTime() {
        DateTime date = DateUtil.date();
        int year = date.year();
        int month = date.month();
        // 第一学期
        if (month >= september) {
            return getTime(year, september);
        }
        if (month < march) {
            return getTime(year - 1, september);
        }
        // 第二学期
        return getTime(year, march);
    }

    /**
     * 获取当前学期的结束时间
     *
     * @return 当前学期的结束时间
     */
    public String findCurrSemesterEndTime() {
        DateTime date = DateUtil.date();
        int year = date.year();
        int month = date.month();
        // 第一学期
        if (month >= september) {
            return getTime(year + 1, march);
        }
        if (month < march) {
            return getTime(year, march);
        }
        // 第二学期
        return getTime(year, september);
    }

    public String getTime(int year, int month) {
        return StrUtil.format("{}-{}-{} 00:00:00", year, month, 1);
    }


    /**
     * 添加黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    @ApiOperation(value = "添加黑名单学生")
    @PostMapping(value = "/addBlack")
    public RespondsMessage addBlack(@RequestParam(value = "publisId") Integer publisId,
                                    @RequestParam(value = "studentIds") List<Integer> studentIds,
                                    Principal principal) {
        if (principal == null) {
            throw new ServiceException(LogUtil.logInfo(log, "用户未登陆添加黑名单那"));
        }
        PublishQuestionnaireModel publication = publishquestionnaireService.addBlack(publisId, studentIds, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publication);
    }

    /**
     * 删除黑名单学生
     *
     * @param publisId   发布id
     * @param studentIds 学生id集合
     * @return 处理后的数据
     */
    @ApiOperation(value = "删除黑名单学生")
    @DeleteMapping(value = "/deleteBlack")
    public RespondsMessage deleteBlack(@RequestParam(value = "publisId") Integer publisId,
                                       @RequestParam(value = "studentIds") List<Integer> studentIds,
                                       Principal principal) {
        PublishQuestionnaireModel publication = publishquestionnaireService.deleteBlack(publisId, studentIds, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publication);
    }

    /**
     * 提交回答信息，
     *
     * @param publisId
     * @param completesQuestion
     * @return
     */
    @ApiOperation(value = "提交回答信息")
    @PostMapping(value = "/writeQuestion")
    public RespondsMessage writeQuestion(@RequestParam(value = "publisId") Integer publisId,
                                         @RequestBody PublishAttachInfo.CompletesQuestion completesQuestion,
                                         Principal principal) {
        PublishQuestionnaireModel publication = publishquestionnaireService.fillInTheAnswer(publisId, completesQuestion, principal);
        return RespondsMessage.success(LogUtil.logInfo(log, "用户{}更新的问题成功", principal.getName()), publication);
    }

    /**
     * 通过id批量获取发布评教卷信息
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量获取发布评教卷的信息")
    @GetMapping(value = "/list/by/ids")
    public RespondsMessage batchFindPublishQuestionInfo(@RequestParam(value = "ids") List<Integer> ids) {
        return RespondsMessage.success("获取发布评教卷信息完成", publishquestionnaireService.findPublishQuestionDeatil(ids));
    }

    /**
     * 老师阅读了发布的评教卷信息
     *
     * @return
     */
    @PutMapping(value = "/teacher/read/publish")
    public RespondsMessage teacherReadPublishQuestionInfo(@RequestParam(value = "publishQuestingId") Integer publishQuesting,
                                                          Principal principal) {
        PublishQuestionnaireModel publication
                = publishquestionnaireService.teacherCheckPendingQuestion(publishQuesting, principal);
        return RespondsMessage.success("获取发布评教卷信息成功", JSON.parseObject(JSON.toJSONString(publication),
                PublishQuestionJsonVo.class));
    }

    /**
     * 学生阅读了发布的评教卷信息
     *
     * @return
     */
    @PutMapping(value = "/student/read/publish")
    public RespondsMessage studentReadPublishQuestionInfo(@RequestParam(value = "publishQuestingId") Integer publishQuesting,
                                                          Principal principal) {
        PublishQuestionnaireModel publication
                = publishquestionnaireService.studentCheckPendingQuestion(publishQuesting, principal);
        return RespondsMessage.success("获取发布评教卷信息成功", publication);
    }

    /**
     * 查询学生在这个评教卷中回答的问题
     *
     * @param publishId
     * @param principal
     * @return
     */
    @GetMapping(value = "/answers")
    public RespondsMessage findStudentAnswers(@RequestParam(value = "publishId") Integer publishId,
                                              Principal principal) {
        AccountModel accountModel
                = accountService.findUserByAccount(principal.getName());

        PublishQuestionnaireModel publishQuestionId
                = publishQuestionBusinessMapper.selectByPrimaryKey(publishId);

        if (publishQuestionId == null) {
            return RespondsMessage.success("评教卷不存在");
        }

        PublishAttachInfo bean = PublishAttachInfo.getBean(publishQuestionId);
        List<PublishAttachInfo.CompletesQuestion> completesQuestions
                = bean.getCompletesQuestions();
        if (CollUtil.isEmpty(completesQuestions)) {
            EvaluationQuestionnaireModel evaluational
                    = evaluationQuestionnaireBusinessMapper
                    .selectByPrimaryKey(publishQuestionId.getQuestionnaireId());
            evaluational.setContent(null);
            AnswersView data = new AnswersView();
            data.setEvaluationquestionnaire(evaluational);
            data.setAnswers(new PublishAttachInfo.CompletesQuestion());
            return RespondsMessage.success("未作答，返回评教卷信息", data);
        }

        for (PublishAttachInfo.CompletesQuestion completesQuestion : completesQuestions) {
            if (completesQuestion.getStudentId().equals(accountModel.getId())) {
                AnswersView answersView = new AnswersView();
                answersView.setAnswers(completesQuestion);
                EvaluationQuestionnaireModel evaluational
                        = evaluationQuestionnaireBusinessMapper
                        .selectByPrimaryKey(publishQuestionId.getQuestionnaireId());

                answersView.setEvaluationquestionnaire(evaluational);
                evaluational.setContent(null);
                return RespondsMessage.success("获取答案完成", answersView);
            }
        }
        return RespondsMessage.success("未作答");
    }


    @Data
    public static class AnswersView {

        private EvaluationQuestionnaireModel evaluationquestionnaire;

        private PublishAttachInfo.CompletesQuestion answers;

    }

    /**
     * 查看发布评教卷的评分
     *
     * @param publishId
     * @return
     */
    @GetMapping(value = "/score")
    public RespondsMessage teacherViewStat(@RequestParam(value = "publishId") Integer publishId) {
        return RespondsMessage.success("获取统计结果完成",
                publishquestionnaireService.getQuestionStatisticalScore(publishId));
    }

    /**
     * 查看发布评教卷的评分
     * 专业维度
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/profession/score")
    public RespondsMessage professionScore(@RequestParam(value = "id") Integer id) {
        Map<String, Object> map = publishquestionnaireService.professionScoreStatistics(id);
        switch ((Integer) map.get("status")) {
            case 1:
                return RespondsMessage.success("该专业未发布评教卷", null);
            case 2:
                return RespondsMessage.success("评教卷还未完全回收", null);
            case 3:
                return RespondsMessage.success("获取统计结果完成",
                        map.get("data"));
        }
        return null;
    }

    /**
     * 查看发布评教卷的评分
     * 学院维度
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/factory/score")
    public RespondsMessage factoryScore(@RequestParam(value = "id") Integer id) {
        Map<String, Object> map = publishquestionnaireService.professionScoreStatistics(id);
        switch ((Integer) map.get("status")) {
            case 1:
                return RespondsMessage.success("该专业未发布评教卷", null);
            case 2:
                return RespondsMessage.success("评教卷还未完全回收", null);
            case 3:
                return RespondsMessage.success("获取统计结果完成",
                        map.get("data"));
        }
        return null;
    }


}