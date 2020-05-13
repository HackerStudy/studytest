package com.hackerstudy.studytest.proxy;

import com.hackerstudy.studytest.util.ReflexUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @ClassName Student
 * @Author HackerStudy
 * @date 2020.05.13 11:03
 */
public class Student implements Person{
    /**
     * 日志
     */
    public static final Logger logger = LoggerFactory.getLogger(Student.class);

    /**
     * 学生名字
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        logger.info("学生:{} 上交班费50元",name);
    }
}
