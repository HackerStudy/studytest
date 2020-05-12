package com.hackerstudy.studytest.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;


/**
 * @class: DateUtilsTest
 * @description:
 * @author: Administrator
 * @date: 2020-03-30 17:13
 */
public class DateUtilsTest {
    Logger logger = LoggerFactory.getLogger(DateUtilsTest.class);

    @Test
    public void betweenMonths() throws ParseException {
        String startTime = "2020-03-31";
        Integer months = DateUtils.betweenMonths(startTime,"2020-09-30");
        String startTimeAdd = DateUtils.addDay(startTime,1);
        Integer months2 = DateUtils.betweenMonths(startTimeAdd,"2020-09-30");
        logger.info("months: "+months);
        logger.info("months: "+months2);
        if(months2<=months){
        }else{
            months = months+1;
        }
    }


    @Test
    public void getDifMonth() {
        try{
            Integer months = DateUtils.getDifMonth("2020-03-31","2020-09-30");
            logger.info("months: "+months);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}