package org.nix.lovedomain.service.constant;

/**
 * @author zhangpei
 * @version 1.0
 * @description 缓存names
 * @date 2019/6/2
 */
public interface CacheConstant {

    /**
     * 评教卷分页缓存
     */
    String EVALUATIONAL_PAGE = "system:EvaluationalPage";
    /**
     * 评教卷的详细信息缓存
     */
    String EVALUATIONAL_DETAIL = "system:EVALUATIONAL_DETAIL";
    /**
     * 检查老师是否可以配置一个评教卷
     */
    String CHECK_TEACHER_CONFIG_PUBLISH_EVALUATIONAL = "system:teacher:can:config:publish:evaluational";
    /**
     * 查询发布评教卷的信息Vo
     */
    String FIND_PUBLISH_QUESTION_VO = "system:find:publish:question:vo";
    /**
     * 查询统计信息缓存
     */
    String STATISTICS_QUESTION_VO = "system:statistics:question:vo";
    /**
     * 用户能够查看的教学任务
     */
    String USER_TEACH_TASK = "system:user:teach:task";
    /**
     * 用户能够查看的教学任务数量
     */
    String USER_TEACH_TASK_NUMBER = "system:user:teach:task:number";
}
