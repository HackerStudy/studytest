package com.hackerstudy.studytest.environment;

import sun.awt.SunHints;

import java.util.Map;

/**
 * @class: EnvironmentVariables
 * @description: 显示所有的操作系统环境变量
 * @author: yangpeng03614
 * @date: 2019-03-29 15:27
 */
public class EnvironmentVariables {

    /**
     * main函数
     * @param args
     */
    public static void main(String[] args) {
        for(Map.Entry entry:System.getenv().entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        //lambda表达式写Map的forEach
        System.getenv().forEach((key,value) -> {
            System.out.println(key+": "+value);
        });
    }
}
