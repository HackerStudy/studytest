package com.hackerstudy.studytest.concurrent;

import static java.lang.Thread.sleep;

/**
 * @class: ListOffThreeRunable
 * @description:
 * @author: Administrator
 * @date: 2019-07-02 22:37
 */
public class LisfOffThreeRunable implements Runnable{
    //倒计时
    private int countDown = 10;

    public LisfOffThreeRunable(int countDown) {
        this.countDown = countDown;
    }

    public LisfOffThreeRunable() {
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始");
        while(countDown>0){
            System.out.println("倒计时"+Thread.currentThread().getName()+"："+countDown);
            //线程休眠进入等待状态释放自己的锁
            try {
                sleep((int) Math.random() * 10); //休眠
                //Thread.yield(); //声明我已经执行完生命周期中最重要的部分了，现在正是切换给其他任务执行一段时间的好时机
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDown--;
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}
