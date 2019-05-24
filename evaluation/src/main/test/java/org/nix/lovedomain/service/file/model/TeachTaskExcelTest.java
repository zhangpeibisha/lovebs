package org.nix.lovedomain.service.file.model;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TeachTaskExcelTest {

    private TeachTaskExcel teachTaskExcel;

    @Before
    public void before() {
        teachTaskExcel = new TeachTaskExcel();
        teachTaskExcel.setTeachTime("07-09");
    }

    @Test
    public void findTeachStartWeek() {
        int teachStartWeek = teachTaskExcel.findTeachStartWeek();
        assertEquals(7, teachStartWeek);
    }

    @Test
    public void findTeachEndWeek() {
        int teachStartWeek = teachTaskExcel.findTeachEndWeek();
        assertEquals(9, teachStartWeek);
    }

    @Test(expected = ValidateException.class)
    public void error() {
        teachTaskExcel.setTeachTime(null);
        teachTaskExcel.findTeachStartWeek();
    }

    @Test
    public void findTeachStartTime() {
        teachTaskExcel.setYear(2019);
        teachTaskExcel.setSemester("第二学期");
        Date teachStartTime = teachTaskExcel.findTeachStartTime();
        String format = DateUtil.format(teachStartTime, "yyyy-MM-dd HH:mm:SS");
        System.out.println(format);
        assertEquals("2020-04-19 00:00:00", format);
    }

    @Test
    public void findTeachEndTime() {
        teachTaskExcel.setYear(2019);
        teachTaskExcel.setSemester("第二学期");
        Date teachStartTime = teachTaskExcel.findTeachEndTime();
        String format = DateUtil.format(teachStartTime, "yyyy-MM-dd HH:mm:SS");
        System.out.println(format);
        assertEquals("2020-05-03 00:00:00", format);
    }

    /**
     * 一个课程多段时间
     */
    @Test
    public void findTeachEndTimeTwoTime() {
        teachTaskExcel.setTeachTime("07-09,10-11,12-19");
        teachTaskExcel.setYear(2019);
        teachTaskExcel.setSemester("第二学期");
        Date teachStartTime = teachTaskExcel.findTeachEndTime();
        String format = DateUtil.format(teachStartTime, "yyyy-MM-dd HH:mm:SS");
        System.out.println(format);
        assertEquals("2020-07-12 00:00:00", format);
    }


    @Test
    public void findReplyStartTime() {
        teachTaskExcel.setYear(2019);
        teachTaskExcel.setSemester("第二学期");
        teachTaskExcel.setEvaluationTime(1);
        Date replyStartTime = teachTaskExcel.findReplyStartTime();
        String format = DateUtil.format(replyStartTime, "yyyy-MM-dd HH:mm:SS");
        System.out.println(format);
        assertEquals("2020-04-26 00:00:00", format);
    }

    @Test(expected = ValidateException.class)
    public void findReplyStartTimeError() {
        teachTaskExcel.setYear(2019);
        teachTaskExcel.setSemester("第二学期");
        teachTaskExcel.setEvaluationTime(3);
        teachTaskExcel.findReplyStartTime();
    }

}