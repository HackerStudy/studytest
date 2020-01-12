package com.hackerstudy.studytest.regex;

import java.util.Arrays;

/**
 * @class: StringRegEx
 * @description: String来实现的正则表达式
 * @author: 17911
 * @date: 2020-01-12 10:44
 */
public class StringRegEx {

    /**
     * 是否包含某个东西
     * @return
     */
    public static boolean isContain(String originalString,String regEx){
        boolean flag = originalString.matches(regEx);
        return flag;
    }

    /**
     * 分割字符串
     * @return
     */
    public static String[] splitString(String originalString,String regEx){
        String[] result = originalString.split(regEx);
        return result;
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        /*
           测试String.matches()方法
         */
        //|表示或者、\\表示转义、()括号表示分组、？表示可能、\d表示整数、+表示一个或者是多个之前的表达式
        System.out.println(isContain("+48212","(-|\\+)?\\d+"));

        /*
           测试String。split()方法
         */
        String originalString = "小:140 大:115 aoc";

        //\W表示非字母字符
        String[] result = splitString(originalString,"\\W+");
        System.out.println(Arrays.toString(result));

        /*
         String.replace()
         */
        //替换全部
        String replaceString = originalString.replaceAll("\\w","你好");
        System.out.println(replaceString);
    }
}
