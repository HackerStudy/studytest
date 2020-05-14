package com.hackerstudy.studytest.generic.pmethod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @class: GenericMethodTest
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-14 10:41
 */
public class GenericMethodTest {

    @Test
    public void f() {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.f("你好");
        genericMethod.f(1);
        //泛型方法的类型推断
        out(genericMethod.f("显示的类型说明"));
        this.<String>out(genericMethod.<String>f("显示的类型说明"));
    }

    /**
     * @description: 验泛型方法的类型推断
     * @param: T
     * @return: void
     * @auther: HackerStudy
     * @date: 2020-05-14 10:58
     * @throws
     */
    public <T> void out(T s){
        System.out.println(s);
    }

    @Test
    public void createList() {
       GenericMethod.createList(1,2,3,4,5);
    }
}