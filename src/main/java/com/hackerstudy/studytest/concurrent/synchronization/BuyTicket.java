package com.hackerstudy.studytest.concurrent.synchronization;

/**
 * @class: BuyTicket
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-08 18:16
 */
public class BuyTicket implements Runnable {
    private int ticket=10;//票数

    @Override
    public void run() {
        //payTicket();
        //同步代码块
        synchronized (this){
            while(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+" 票数："+ticket--);
            }
        }
    }

    /**
     * 同步方法
     */
    private synchronized void payTicket(){
        while(this.ticket>0){
            System.out.println(Thread.currentThread().getName()+" 票数："+ticket--);
        }
    }
}
