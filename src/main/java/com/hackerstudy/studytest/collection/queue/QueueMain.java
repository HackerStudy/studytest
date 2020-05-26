package com.hackerstudy.studytest.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @class: QueueMain
 * @description: Queue(队列)的测试类
 * @author: yangpeng03614
 * @date: 2019-03-22 09:16
 */
public class QueueMain {
    public static void main(String[] args) {
        //linkedList实现的队列
        testQueue();
        //PriorityQueue实现的优先级队列
        testPriorityQueue();
    }

    /**
     * 测试Queue(队列)的添加和遍历
     */
    public static void testQueue(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        while(queue.peek()!=null){
            System.out.println(queue.remove());
        }
    }

    /**
     * 优先级队列PriorityQueue
     */
    public static void testPriorityQueue(){
        ToDoList toDoList= new ToDoList();
        toDoList.add("niaho",'a',1);
        toDoList.add("niahowqe",'a',2);
        toDoList.add("niahozxcz",'b',1);
        toDoList.add("niahoxzc",'c',1);
        toDoList.add("niahocv",'c',1);
        while (!toDoList.isEmpty()){
            System.out.println(toDoList.remove());
        }
    }
}
