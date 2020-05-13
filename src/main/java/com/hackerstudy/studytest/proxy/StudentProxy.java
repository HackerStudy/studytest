package com.hackerstudy.studytest.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @class: StudentProxy
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-13 11:11
 */
public class StudentProxy implements Person {
    public static final Logger logger = LoggerFactory.getLogger(StudentProxy.class);

    private Student student;

    public StudentProxy(Student student) {
        this.student = student;
    }

    @Override
    public void giveMoney() {
        logger.info("班长代缴班费");
        student.giveMoney();
    }
}
