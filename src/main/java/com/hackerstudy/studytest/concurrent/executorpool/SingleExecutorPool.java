package com.hackerstudy.studytest.concurrent.executorpool;

import com.hackerstudy.studytest.concurrent.LisfOffThreeRunable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @class: FixExecutorPool
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-05 11:35
 */
public class SingleExecutorPool {

    public static void main(String[] args) {
        ExecutorService exec= Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            exec.execute(new LisfOffThreeRunable());
        }
        exec.shutdown();
    }
}
