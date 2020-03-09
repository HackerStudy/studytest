package com.hackerstudy.studytest.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @class: StringRegEx
 * @description: String来实现的正则表达式
 * @author: 17911
 * @date: 2020-01-12 10:44
 */
public class StringRegEx {

    /**
     * 匹配电话号码的表达式
     */
    public static String phoneRegEx = "(0\\d{2,3}-\\d{7,8})|(1[3578]\\d{9})";

    /**
     * 匹配邮箱的表达式
     */
    public static String emailRegEx = "[\\w]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]{2,4}){1,2}";

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
     * 获取正则中包含的内容
     * @return
     */
    public static List<String> getContainStringList(String originalString,String regEx){
        List<String> returnStringList = new ArrayList<>();
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(originalString);
        while(m.find()) {
            returnStringList.add(m.group());

        }
        return returnStringList;
    }

    /**
     * 只替换匹配到的第一个内容
     * @param originalString
     * @param regEx
     */
    public static void replaceStringFirst(String originalString,String regEx){
        originalString.replaceFirst(regEx,"替换");
    }

    /**
     * 替换匹配到的全部内容
     * @param originalString
     * @param regEx
     */
    public static void replaceStringAll(String originalString,String regEx){
        originalString.replaceAll(regEx,"替换");
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

        //获取文本中的电话号码
        String phoneStringText = "21312adasda 0731-43022312 15673331468";
        List<String> phoneList = getContainStringList(phoneStringText,phoneRegEx);
        System.out.println(phoneList.toString());

        //获取邮箱号
        String emailStringText = "21312adasda 0731-43022312 15673331468,17821312@qq.com qweqwe@sina.com qweqwe@163.com";
        List<String> emailList = getContainStringList(emailStringText,emailRegEx);
        System.out.println(emailList.toString());
    }
}
