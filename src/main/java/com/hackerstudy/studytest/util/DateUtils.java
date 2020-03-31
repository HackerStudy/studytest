package com.hackerstudy.studytest.util;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @class: DateUtils
 * @description: 日期的工具类
 * @author: yangpeng
 * @date: 2020-03-30 16:58
 */
public class DateUtils {

    /**
     * 获取两个时间之间相差的月份
     * @param startDate
     * @param endDate
     * @return
     */
    public static Integer betweenMonths(String startDate,String endDate){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime start = formatter.parseDateTime(startDate);
        DateTime end = formatter.parseDateTime(endDate);
        Integer months = Months.monthsBetween(start,end).getMonths();
        return months;
    }

    /**
     * 计算两个时间之间相差的月份
     * @param startDate
     * @param endDate
     * @return
     */
    public static Integer getDifMonth(String startDate, String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(sdf.parse(startDate));
        end.setTime(sdf.parse(endDate));
        int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }

    /**
     * 在输入日期上增加（+）或减去（-）天数
     *
     * @param date
     *      输入日期
     * @param iday
     *      要增加或减少的天数
     */
    public static String addDay(String date, int iday) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cd = Calendar.getInstance();
        cd.setTime(sdf.parse(date));
        cd.add(Calendar.DAY_OF_MONTH, iday);
        return sdf.format(cd.getTime());
    }

}
