package com.hackerstudy.studytest.util;

/**
 * @class: StringUtils
 * @description: 关于字符串的工具类
 * @author: Administrator
 * @date: 2019-08-28 20:32
 */
public class StringUtils {

    /**
     * 获取相同字符串的出现次数
     * @param sourceString
     * @param appointString
     * @return
     */
    public static int getSameStringAppearCounts(String sourceString,String appointString){
        int counts = 0;
        int index = 0;
        while((index = sourceString.indexOf(appointString,index))!=-1){
            counts++;
            index++;
        }
        return counts;
    }
}
