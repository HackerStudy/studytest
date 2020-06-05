package com.hackerstudy.studytest.concurrent.executorpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @class: CallableDemo
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-05 11:40
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        List<Future<String>> futures=new ArrayList<Future<String>>();
        for(int i=0;i<10;i++){
            futures.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> future:futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}
