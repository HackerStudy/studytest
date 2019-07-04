package com.hackerstudy.studytest.annotation;

import java.lang.reflect.Field;

/**
 * @class: AnnotationResolver
 * @description: 注解解析器
 * @author: Administrator
 * @date: 2019-07-02 20:49
 */
public class AnnotationResolver {

    /**
     * lengthDetection注解的解析
     */
    public static void lengthResolver(Object obj) throws IllegalAccessException,Exception{
        Class<?> clazz = obj.getClass(); //通过反射机制获取对象
        Field[] fields = clazz.getDeclaredFields(); //获取该对象的所有成员变量
        for (Field field:fields){
            LengthDetection lengthDetection = field.getAnnotation(LengthDetection.class);//获取属性上的@LengthDetection注解
            if(lengthDetection != null){
                field.setAccessible(true);//破解私有属性
                if("class java.lang.String".equals(field.getGenericType().toString())){//字符串类型的才判断长度
                    String value = (String)field.get(obj);
                    System.out.println("fieldValue:"+value);
                    if(value != null && ((value.length() > lengthDetection.max()) || value.length() < lengthDetection.min())){
                        throw new Exception(lengthDetection.description());
//                        System.out.println(lengthDetection.description());
                    }
                }
            }
        }
    }
}
