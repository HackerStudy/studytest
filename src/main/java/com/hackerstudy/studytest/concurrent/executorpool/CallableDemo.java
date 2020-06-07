package com.hackerstudy.studytest.concurrent.executorpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

        //用Thread控制Callable
        Callable<String> callable = new TaskWithResult(1);
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
