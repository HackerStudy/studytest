package com.hackerstudy.studytest.environment;

/**
 * @class: EnvironmentVariables
 * @description: 显示系统中所有的环境变量
 * @author: yangpeng03614
 * @date: 2019-03-29 15:27
 */
public class EnvironmentVariables {

    /**
     * main函数
     * @param args
     */
    public static void main(String[] args) {
        //for(Map.Entry entry:System.getenv().entrySet()){
        //    System.out.println(entry.getKey()+": "+entry.getValue());
        //}
        //
        ////lambda表达式写Map的forEach
        //System.getenv().forEach((key,value) -> {
        //    System.out.println(key+": "+value);
        //});

        //获取系统环境的信息
        System.getProperties().list(System.out);
    }
}
