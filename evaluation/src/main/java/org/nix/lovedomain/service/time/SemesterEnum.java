package org.nix.lovedomain.service.time;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Date;

/**
 * @author zhangpei
 * @version 1.0
 * @description 学期的枚举
 * @date 2019/5/22
 */
public enum SemesterEnum {

    /**
     * 学生上课学期
     * startMonth：为开始的月份，以1日进行结算
     * endMonth：为结束月份，以31日结算
     */
    FIRST(9, 3, "第一学期"), SECOND(3, 7, "第二学期");

    private int startMonth;
    private int endMonth;
    private String name;

    public static String first = "第一学期";
    public static String second = "第二学期";

    SemesterEnum(int startMonth, int endMonth, String name) {
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.name = name;
    }

    /**
     * 通过学期名字获取学期的枚举信息
     *
     * @param name 学期名字
     * @return 学期枚举
     */
    public static SemesterEnum findSemesterByName(String name) {
        if (first.equals(name)) {
            return FIRST;
        }
        return SECOND;
    }

    /**
     * 比如2019 第一学期，那么该学期的开始时间为 2019年9月，则直接返回2019
     * 但是2019 第二学期，则是2020年3月份呢开始，所有返回的时间需要+1
     *
     * @param year         学年
     * @param semesterName 学期名字
     * @return 学年年份，主要用来计算学年开始时间
     */
    public static int findStartTimeYear(int year, String semesterName) {
        if (first.equals(semesterName)) {
            return year;
        }
        return year + 1;
    }

    /**
     * 获取一学期的开始时间
     *
     * @param year         年份
     * @param semesterName 学期名字
     * @return
     */
    public static Date findSchoolYearStartTime(int year, String semesterName) {
        SemesterEnum semesterByName = findSemesterByName(semesterName);
        int startMonth = semesterByName.getStartMonth();
        String strTime = StrUtil.format("{}-{}-01 00:00:00", findStartTimeYear(year, semesterName), startMonth);
        return DateUtil.parse(strTime);
    }

    /**
     * 计算学期第几周的时间
     *
     * @param year         学年
     * @param semesterName 学期名字
     * @param week         该学期的周
     * @return 指定周的时间
     */
    public static Date semesterWeekTime(int year, String semesterName, int week) {
        Date schoolYearStartTime = findSchoolYearStartTime(year, semesterName);
        return DateUtil.offsetWeek(schoolYearStartTime, week);
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
