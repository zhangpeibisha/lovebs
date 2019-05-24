package org.nix.lovedomain.dao.business.json.student;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.dao.model.StudentModel;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生任务
 * @date 2019/4/28
 */
@Data
public class StudentTask {

    /**
     * 学生的评教卷任务
     */
    private QnaireTask qnaireTask;


    public static StudentTask str2Bean(StudentModel student) {
        String task = student.getTask();
        if (task == null || "".equals(task)){
            return new StudentTask();
        }
        return JSONUtil.toBean(task,StudentTask.class);
    }

}
