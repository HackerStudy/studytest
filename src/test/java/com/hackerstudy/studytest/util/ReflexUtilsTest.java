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
}