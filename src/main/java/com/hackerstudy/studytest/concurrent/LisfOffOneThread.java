package com.hackerstudy.studytest.concurrent;

import javax.sound.midi.Soundbank;

/**
 * @class: LisfOffThread
 * @description:
 * @author: Administrator
 * @date: 2019-07-02 22:16
 */
public class LisfOffOneThread extends Thread{
    //倒计时
    private int countDown = 10;

    public LisfOffOneThread() {
    }

    public LisfOffOneThread(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始");
        while(countDown>0){
            System.out.println("倒计时"+Thread.currentThread().getName()+"："+countDown);
            //休眠时间
            int sleepTime = (int)Math.random() * 10;
            //线程休眠进入等待状态释放自己的锁
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(countDown<2){
                //让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会
                yield();
            }
            countDown--;
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}
