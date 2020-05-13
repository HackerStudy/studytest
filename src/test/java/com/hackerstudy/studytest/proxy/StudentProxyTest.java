package com.hackerstudy.studytest.proxy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @class: StudentProxyTest
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-13 11:16
 */
public class StudentProxyTest {

    @Test
    public void giveMoney() {
        Student student = new Student();
        student.setName("张三");
        StudentProxy studentProxy = new StudentProxy(student);
        studentProxy.giveMoney();
    }
}