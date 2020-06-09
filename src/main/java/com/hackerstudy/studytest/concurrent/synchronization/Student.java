package com.hackerstudy.studytest.concurrent.synchronization;

/**
 * @class: Student
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-08 20:15
 */
public class Student {
    //姓名
    private String name;
    //信息
    private String message;
    //同步标识
    private boolean flag=true;

    //flag=true表示生产者可以生产，但是消费者不可以消费
    //flag=false表示消费者可以消费，但是生产者不可以生产

    public Student(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Student() {
    }

    public synchronized void set(String name,String message) throws InterruptedException {
        if(flag==false){
            wait(); //需要进行等待
        }
        this.name = name;
        this.message= message;
        System.out.println(this.name+"-"+this.message);
        flag=false;
        notify();
    }

    public synchronized void get() throws InterruptedException {
        if(flag==true){
            wait(); //需要进行等待
        }
        System.out.println(this.name+"-"+this.message);
        flag = false;
        notify();
    }
}
