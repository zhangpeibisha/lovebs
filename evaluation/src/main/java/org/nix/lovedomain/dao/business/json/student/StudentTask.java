package org.nix.lovedomain.dao.business.json.student;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.business.json.teacher.TeacherWork;
import org.nix.lovedomain.model.Teacher;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生任务
 * @date 2019/4/28
 */
@Data
public class StudentTask {

    /**
     * 学生的问卷任务
     */
    private QnaireTask qnaireTask;

    /**
     * 将数据库中存储的工作信息转换为json格式
     *
     * @param teacher
     * @return
     */
    public static TeacherWork str2Bean(Teacher teacher) {
        String workjson = teacher.getWorkjson();
        if (workjson == null) {
            return new TeacherWork();
        }
        return JSONUtil.toBean(workjson, TeacherWork.class);
    }

}
