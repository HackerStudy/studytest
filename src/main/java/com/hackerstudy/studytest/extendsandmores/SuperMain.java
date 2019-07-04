package com.hackerstudy.studytest.extendsandmores;

/**
 * @class: SuperMain
 * @description:
 * @author: Administrator
 * @date: 2019-05-16 22:16
 */
public class SuperMain {
    public static void main(String[] args) {
        test();
        test2();
        test3();
    }

    public static void test(){
        SuperClass superClass = new SonClass();
        System.out.println(((SonClass) superClass).i);
    }

    public static void test2(){
        SuperClass superClass = new SuperClass();
        System.out.println(superClass.i);
    }

    public static void test3(){
        SuperClass superClass = new Son2Class();
        System.out.println(((Son2Class)superClass).i);
    }
}
