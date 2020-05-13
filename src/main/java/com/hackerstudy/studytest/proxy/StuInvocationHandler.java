package com.hackerstudy.studytest.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @class: StuInvocationHandler
 * @description: 学生的jdk动态代理类
 * @author: HackerStudy
 * @date: 2020-05-13 11:45
 */
public class StuInvocationHandler<T> implements InvocationHandler {
    public static final Logger logger = LoggerFactory.getLogger(StuInvocationHandler.class);
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * @description: 代理方法的重定向预处理
     * @param: [o, method, objects]
     * @return: java.lang.Object
     * @auther: HackerStudy
     * @date: 2020-05-13 11:52
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        logger.info("正在进行代理,代理方法为:{}",method.getName());
        Object result = method.invoke(target, objects);
        return result;
    }
}
