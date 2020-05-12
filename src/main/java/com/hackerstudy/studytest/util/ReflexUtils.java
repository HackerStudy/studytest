package com.hackerstudy.studytest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @class: ReflexUtils
 * @description: 反射的工具类
 * @author: 17911
 * @date: 2020-05-12 21:13
 */
public class ReflexUtils {
    public static final Logger logger = LoggerFactory.getLogger(ReflexUtils.class);
    /**
     * 正则表达式
     */
    private static Pattern p = Pattern. compile("\\w+\\.");

    /**
     * 遍历反射中class中的信息
     */
    public static void ergodicClassInfo(String className){
        try {
            Class<?> c = Class.forName(className);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            logger.info("开始遍历class对象中的信息");

            for(Method method:methods){
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }

            for(Constructor constructor:constructors){
                System.out.println(p.matcher(constructor.toString()).replaceAll(""));
            }
            logger.info("遍历结束");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("反射获取信息失败={}",e.getMessage());
        }
    }
}

