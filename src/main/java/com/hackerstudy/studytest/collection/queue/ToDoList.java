package com.hackerstudy.studytest.collection.queue;

import java.util.PriorityQueue;

/**
 * @class: ToDoList
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-26 15:22
 */
public class ToDoList extends PriorityQueue<ToDoItem> {

    public void add(String item,char primary,int secondary){
        super.add(new ToDoItem(primary,secondary,item));
    }
}
