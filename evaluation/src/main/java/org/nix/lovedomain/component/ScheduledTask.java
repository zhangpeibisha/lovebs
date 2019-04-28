package org.nix.lovedomain.component;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.nix.lovedomain.dao.business.json.task.QnaireTaskItem;
import org.nix.lovedomain.dao.mapper.EvaluationquestionnaireMapper;
import org.nix.lovedomain.dao.mapper.TeacherMapper;
import org.nix.lovedomain.model.Publishquestionnaire;
import org.nix.lovedomain.model.Student;
import org.nix.lovedomain.model.Teacher;
import org.nix.lovedomain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @anthor on 2019/4/23
 * @since jdk8
 * <p>
 * 定时任务调度,用于定时扫描发布的问卷是否可以正真的发送到用户
 * 的任务里，并且检测任务是否结束，如果结束了则需要执行回收任务
 * 每天凌晨0点执行
 */
@Component
public class ScheduledTask {

    @Autowired
    private PublishquestionnaireService publishquestionnaireService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherCourseService teacherCourseService;

    @Resource
    private EvaluationquestionnaireMapper evaluationquestionnaireMapper;

    @Autowired
    private EmailService emailService;

    /**
     * 存储需要发送信息的邮箱地址，
     * 需要在最后把该映射删除，防止第二天还有
     * 前一天用户的邮件地址
     */
    private HashMap<String, String> hashMap;

    /**
     * 定时任务，每天凌晨0点执行。
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void excuteTask() {

        hashMap = new HashMap<>();

        // 获取需要发布的所有问卷
        List<Publishquestionnaire> publishquestionnaires = getPublishquestionnaires();

        // 配置任务
        configurationTasks(publishquestionnaires);

        // 发送邮件
        sendEmails();

    }


    /**
     * 配置任务
     */
    private void configurationTasks(List<Publishquestionnaire> publishquestionnaires) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm-dd hh:mm:ss");

        //jackson对象映射类
        ObjectMapper MAPPER = new ObjectMapper();

        /**给该问卷下所有的学生设置任务**/
        for (Publishquestionnaire p : publishquestionnaires) {

            // 获取需要处理该问卷的所有学生
            List<Student> students = getStudentByCourse(p.getTeacherid(), p.getCourseid());
            for (Student s : students) {
                String task = s.getTask();
                // 学生当前没有要处理的任务
                ArrayList<QnaireTaskItem> stduentTasks = null;
                if (task == null || task.equals("")) {
                    stduentTasks = new ArrayList<>();
                } else {//学生当前已经有要处理的任务
                    JavaType jt = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, QnaireTaskItem.class);
                    try {
                        stduentTasks = MAPPER.readValue(task, jt);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                stduentTasks.add(new QnaireTaskItem(p.getId(), p.getEndrespondtime()));
                try {
                    s.setTask(MAPPER.writeValueAsString(stduentTasks));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (s.getEmail() != null && !s.getEmail().equals("")) {
                    /*如果还没有记录需要发送的邮箱则记录，如果记录的问卷过期时间大于当前问卷过期时间则重新记录*/
                    if (hashMap.get(s.getEmail()) == null ||
                            hashMap.get(s.getEmail()).compareTo(simpleDateFormat.format(p.getEndrespondtime())) > 0) {
                        hashMap.put(s.getEmail(), simpleDateFormat.format(p.getEndrespondtime()));
                    }
                }

            }

            //学生的任务重新写回数据库
            writeStudentTask(students);

            /**给该问卷下的老师设置任务**/
            Teacher teacher = (Teacher) teacherService.findById(p.getTeacherid());
            String workJson = teacher.getWorkjson();
            ArrayList<QnaireTaskItem> teacherTask = null;
            if (workJson == null || workJson.equals("")) {
                teacherTask = new ArrayList<>();
            } else {
                JavaType jt = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, QnaireTaskItem.class);
                try {
                    teacherTask = MAPPER.readValue(workJson, jt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            teacherTask.add(new QnaireTaskItem(p.getId(), p.getEndrespondtime()));

            try {
                teacher.setWorkjson(MAPPER.writeValueAsString(teacherTask));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (teacher.getEmail() != null && !teacher.getEmail().equals("")) {
                /**如果还没有记录需要发送的邮箱则记录，如果记录的问卷过期时间大于当前问卷过期时间则重新记录**/
                if (hashMap.get(teacher.getEmail()) == null ||
                        hashMap.get(teacher.getEmail()).compareTo(simpleDateFormat.format(p.getEndrespondtime())) > 0) {
                    hashMap.put(teacher.getEmail(), simpleDateFormat.format(p.getEndrespondtime()));
                }
            }

            // 将老师的任务重新写回数据库
            writeTeacherTask(teacher);

        }
    }

    /**
     * 邮件发送
     */
    private void sendEmails() {

    }

    /**
     * 学生的任务重新写回数据库
     *
     * @param students
     */
    private void writeStudentTask(List<Student> students) {
        studentService.writeStudentTask(students);
    }

    /**
     * 老师的任务重新写回数据库
     *
     * @param teacher
     */
    private void writeTeacherTask(Teacher teacher) {
        try {
            teacherService.update(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取所有需要发布的问卷
     *
     * @return List<Publishquestionnaire>
     */
    private List<Publishquestionnaire> getPublishquestionnaires() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return publishquestionnaireService.getAllDataByLimit(simpleDateFormat.format(new Date()));
    }

    /**
     * 根据课程读取所有的学生
     *
     * @param teacherId 老师id
     * @param courseId  课程id
     * @return
     */
    private List<Student> getStudentByCourse(Integer teacherId, Integer courseId) {
        return studentService.getStudentByCourse(teacherId, courseId);
    }
}
