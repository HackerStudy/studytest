package com.hackerstudy.studytest.queue;

import java.util.Collections;
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
        testQueue();
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

    public static void testPriorityQueue(){

    }
}
