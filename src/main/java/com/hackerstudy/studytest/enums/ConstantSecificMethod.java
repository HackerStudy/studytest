package com.hackerstudy.studytest.enums;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @class: ConstantSecificMethod
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-04 16:06
 */
public enum ConstantSecificMethod {
    DATETIME{
        @Override
        String getInfo(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ss HH:MM:ss sss");
            Date nowDate = new Date();
            return dateFormat.format(nowDate).toString();
        }
    },
    CLASSPATH{
        @Override
        String getInfo(){
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        @Override
        String getInfo(){
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();
}
