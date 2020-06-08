package com.hackerstudy.studytest.concurrent.synchronization;

/**
 * @class: Product
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-08 20:23
 */
public class Product implements Runnable{
    private Student student;

    public Product(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println("生产第"+i+"笔数据");
            if(i % 2 == 0){
                try {
                    student.set("张三","你好");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    student.set("李四","你好");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
