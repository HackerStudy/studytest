package com.hackerstudy.studytest.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @class: ReflexUtilsTest
 * @description: 测试用反射工具类
 * @author: 17911
 * @date: 2020-05-12 21:29
 */
public class ReflexUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void ergodicClassInfo() {
        String className = "com.hackerstudy.studytest.util.ReflexUtils";
        ReflexUtils.ergodicClassInfo(className);
    }

    @Test
    public void testErgodicClassInfo() {
        Class c=ReflexUtils.class;
        ReflexUtils.ergodicClassInfo(c);
    }

    /**
     * @description: 鸡兔同笼问题，（解方程组）
     * @auther: Hacker
     * @date: 2021-6-18 11:52
     * @throws
     */
    @Test
    public void testChickenAndRabbitInTheSameCage() {
        int chicken = 0;
        int rabbit = 0;
        int head = 30;
        int foot = 88;
        for (int i = 0; i < head; i++) {
            if(i*2+(head-i)*4==foot){
                chicken = i;
            }
        }
        System.out.println("chicken: "+chicken+" rabbit: "+rabbit);
    }

    @Test
    public void testladsda() {
        System.out.println(9/2);
        System.out.println(9%2);
        System.out.println(9.0d/2);
    }

    @Test
    public void testAdd() {
        int[] arrays = {1,2,3};
        for (int i = 0; i < arrays.length; i++) {
            
        }

    }
}