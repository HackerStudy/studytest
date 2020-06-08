package com.hackerstudy.studytest.concurrent.synchronization;

import lombok.SneakyThrows;

/**
 * @class: Customer
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-08 20:26
 */
public class Customer implements Runnable {
    private Student student;

    public Customer(Student student) {
        this.student = student;
    }

    @SneakyThrows
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println("接收第"+i+"笔数据");
            student.get();
        }
    }
}
