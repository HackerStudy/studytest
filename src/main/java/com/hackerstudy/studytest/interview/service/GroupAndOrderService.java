package com.hackerstudy.studytest.interview.service;

import com.hackerstudy.studytest.interview.dao.StudentDao;
import com.hackerstudy.studytest.interview.entity.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @class: GroupAndOrderService
 * @description: 获取每个班成绩最好的学生的信息（SQL为主）
 * @author: Administrator
 * @date: 2019-08-21 22:48
 */
@Slf4j
public class GroupAndOrderService {

    public static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {
        List<Student> students = studentDao.findRankingByClass();
        log.info("id name class score");
        for(Student student:students){
            log.info("{}  {}   {}    {}",
                    String.valueOf(student.getId()),student.getName(),student.getSClass(),
                    String.valueOf(student.getScore()));
        }
    }
}
