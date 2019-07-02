package com.hackerstudy.studytest.concurrent;

/**
 * @class: LisfOffThread
 * @description:
 * @author: Administrator
 * @date: 2019-07-02 22:16
 */
public class LisfOffTwoThread extends Thread{
    //倒计时
    private int countDown = 10;

    public LisfOffTwoThread() {
    }

    public LisfOffTwoThread(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始");
        while(countDown>0){
            System.out.println("倒计时"+Thread.currentThread().getName()+"："+countDown);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDown--;
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}
