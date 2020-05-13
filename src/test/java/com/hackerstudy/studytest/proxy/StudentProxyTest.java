package com.hackerstudy.studytest.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

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
        /*
        静态代理
         */
        Student student = new Student();
        student.setName("张三");
        StudentProxy studentProxy = new StudentProxy(student);
        studentProxy.giveMoney();

        /*
        动态代理
         */
        //被代理类
        Person stu = new Student("李四");
        //Person的调用处理器
        InvocationHandler stuInvocationHandler = new StuInvocationHandler<Person>(stu);
        //创建代理类
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class<?>[]{Person.class},stuInvocationHandler);
        stuProxy.giveMoney();
    }
}