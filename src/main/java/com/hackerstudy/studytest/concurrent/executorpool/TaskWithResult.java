package com.hackerstudy.studytest.concurrent.executorpool;

import java.util.concurrent.Callable;

/**
 * @class: TaskWithResult
 * @description:
 * @author: HackerStudy
 * @date: 2020-06-05 11:39
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "this result:"+id;
    }
}
