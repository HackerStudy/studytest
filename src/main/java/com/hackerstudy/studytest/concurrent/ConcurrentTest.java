package com.hackerstudy.studytest.concurrent;

/**
 * @class: ConcurrentTest
 * @description:
 * @author: Administrator
 * @date: 2019-07-02 22:22
 */
public class ConcurrentTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程开始");
        LisfOffOneThread lisfOffOneThread = new LisfOffOneThread();
        //设置优先级
//        lisfOffOneThread.setPriority(10);
        //线程开始
        lisfOffOneThread.start();
        LisfOffTwoThread lisfOffTwoThread = new LisfOffTwoThread();
        lisfOffTwoThread.start();
        LisfOffThreeRunable lisfOffThreeRunable = new LisfOffThreeRunable();
        Thread lisfOffThreeThread = new Thread(lisfOffThreeRunable);
        lisfOffThreeThread.start();
        System.out.println("当前程序中活跃的线程数："+Thread.activeCount());
        //判断当前线程是否存活
        if(lisfOffOneThread.isAlive()){
            System.out.println(lisfOffOneThread.getName()+"存活");
        }
        //join该线程后面的代码等待该线程终止后才执行
        try {
            lisfOffThreeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World");
    }
}
