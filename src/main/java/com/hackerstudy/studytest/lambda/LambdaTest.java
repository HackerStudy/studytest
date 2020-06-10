package com.hackerstudy.studytest.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @class: LambdaTest
 * @description: lambda表达式的测试
 * @author: HackerStudy
 * @date: 2020-06-10 12:13
 */
public class LambdaTest {

    public static void main(String[] args) {
        anonymousInnerClass();
        multilineLambda();
        int i=onelineLambda();
        System.out.println("add():"+i);
    }

    /**
     * 用匿名内部类实现
     */
    public static void anonymousInnerClass(){
        IMessage iMessage = new IMessage() {
            @Override
            public void send(String str) {
                System.out.println(str);
            }
        };
        iMessage.send("anonymousInnerClass");
    }

    /**
     * 用lambda表达式实现多行
     */
    public static void multilineLambda(){
        IMessage iMessage = str -> System.out.println(str);
        iMessage.send("lambda");
    }

    /**
     * 用lambda表达式实现多行
     */
    public static int onelineLambda(){
        IMath iMath =  (x,y) -> x+y;
        return iMath.add(1,2);
    }

    /**
     * 带参数的lambda表达式
     */
    public static void parameterLambda(){
        IMath iMath = (int x,int y) -> {
            System.out.println("输出计算结果");
            return x+y;
        };
        System.out.println(iMath.add(2,3));
    }

    /**
     * 不带参数的lambda表达式
     */
    public static void noParameterLambda(){
        NoParamter noParamter = () -> System.out.println("无参数输出");
        noParamter.print();
    }

    /**
     * forEach循环的lambda表达式
     */
    public static void forEachLambda(){
        String[] strings = {"1","2","3"};
        List<String> stringList= Arrays.asList(strings);
        stringList.forEach((str) -> {
            System.out.println(str);
        });
    }

    /**
     * Comparator的lambda表达式
     */
    public static void comparatorLambda(){
        String[] strings = {"1","2","3"};
        Arrays.sort(strings,(String str1,String str2) -> str1.compareTo(str2));
        System.out.println(strings.toString());
    }
}
