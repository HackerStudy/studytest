package com.hackerstudy.studytest.jdk8.lambda;

/**
 * @class: IMath
 * @description: 计算接口
 * @author: HackerStudy
 * @date: 2020-06-10 12:20
 */
//函数式编程的注解
@FunctionalInterface
public interface IMath {
    default void jump() {
        System.out.print("default jump()");
    }

    static void desc() {
        System.out.print("static desc()");
    }

    int add(int x,int y);
}
