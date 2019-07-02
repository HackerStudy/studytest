package com.hackerstudy.studytest.annotation;

/**
 * @class: LengthDetectionTest
 * @description: 测试LengthDetection这个自定义注解
 * @author: Administrator
 * @date: 2019-07-02 21:01
 */
public class LengthDetectionTest {
    public static void main(String[] args) {
        StringLength stringLength = new StringLength();
        stringLength.setCode("你");
        try{
            AnnotationResolver.lengthResolver(stringLength);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
