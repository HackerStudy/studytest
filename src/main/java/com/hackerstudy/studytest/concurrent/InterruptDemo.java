package com.hackerstudy.studytest.concurrent;

/**
 * @class: InterruptDemo
 * @description: 中断
 * @author: HackerStudy
 * @date: 2020-06-08 17:35
 */
public class InterruptDemo {

    public static void main(String[] args) {
        Thread thread= new Thread(new LisfOffThreeRunable());
        thread.start();
        System.out.println("线程名字:"+thread.getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
