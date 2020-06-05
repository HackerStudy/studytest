package com.hackerstudy.studytest.concurrent.executorpool;

import com.hackerstudy.studytest.concurrent.LisfOffThreeRunable;
import com.hackerstudy.studytest.concurrent.SimplePriorities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @class: CacheExecutorPool
 * @description: 不指定线程创建数量的线程池
 * @author: HackerStudy
 * @date: 2020-06-05 11:25
 */
public class CacheExecutorPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new LisfOffThreeRunable());
            //线程执行的优先级
            executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.shutdown();
    }
}
