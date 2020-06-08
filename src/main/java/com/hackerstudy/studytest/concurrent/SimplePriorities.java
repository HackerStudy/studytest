package com.hackerstudy.studytest.concurrent;

/**
 * @class: SimplePriorities
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-05 11:46
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double b;
    //优先级
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i=0;i<100000;i++){
                b +=(Math.PI+Math.E)/(double) i;
                if(i%1000==0){
                    //礼让
                    Thread.yield();
                }
            }

            System.out.println(this);
            if(--countDown==0){
                return;
            }
        }
    }
}
