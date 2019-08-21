package com.hackerstudy.studytest.interview.entity;

import lombok.Data;

/**
 * @class: Student
 * @description: 学生的实体类
 * @author: Administrator
 * @date: 2019-08-21 22:51
 */
@Data
public class Student {
    private int id;
    private String name;
    private String sClass;
    private int score;
}
