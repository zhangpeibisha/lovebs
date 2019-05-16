package org.nix.lovedomain.dao.business.page;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学生分页查询类
 * @date 2019/4/7
 */
public class StudentPageInquire extends AbstractPageInquire {

    private Set<String> fields = CollUtil.newHashSet("student.studentid",
            "student.name", "student.phone", "student.email");

    @Override
    protected void checkField(String quireField) {
        quireField = "student."+quireField;
        this.quireField = quireField;
        if (!fields.contains(quireField)) {
            throw new SQLPageException("字段" + quireField + "查询不合法");
        }
    }
}
