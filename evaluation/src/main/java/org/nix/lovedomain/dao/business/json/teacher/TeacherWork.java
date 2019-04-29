package org.nix.lovedomain.dao.business.json.teacher;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import org.nix.lovedomain.dao.business.json.task.QnaireTask;
import org.nix.lovedomain.model.Teacher;

/**
 * @author zhangpei
 * @version 1.0
 * @description 老师工作的配置类，方便添加各种工作需求配置
 * @date 2019/4/27
 */
@Data
public class TeacherWork {

    /**
     * 老师的问卷任务
     */
    private QnaireTask qnaireTask;

    /**
     * 将数据库中存储的工作信息转换为json格式
     * @param teacher
     * @return
     */
    public static TeacherWork str2Bean(Teacher teacher) {
        String workjson = teacher.getWorkjson();
        if (workjson == null || "".equals(workjson)) {
            return new TeacherWork();
        }
        return JSONUtil.toBean(workjson, TeacherWork.class);
    }

}
