package com.hackerstudy.studytest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @class: LengthDetection
 * @description: 字符串长度检测
 * @author: Administrator
 * @date: 2019-07-02 20:41
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthDetection {
    int max() default 10;
    int min() default 0;
    String description() default "字符串的默认长度在0-10";
}
