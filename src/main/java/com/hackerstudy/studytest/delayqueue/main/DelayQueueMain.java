package com.hackerstudy.studytest.delayqueue.main;

import com.alibaba.fastjson.JSON;
import com.hackerstudy.studytest.delayqueue.OrderDelay;
import org.springframework.util.StopWatch;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Class: DelayQueueMain
 * @Description:
 * @Author: NING MEI
 * @Date: 2022-07-22 17:15
 * @Version: 1.0
 */
public class DelayQueueMain {

    public static void main(String[] args) {
        jdkDelayQueue();
    }

    /**
     * jdk 的DelayQueue实现延时队列
     */
    private static void jdkDelayQueue() {
        DelayQueue<OrderDelay> queue = new DelayQueue<>();
        Long orderId = 1L;
        //延迟3秒
        long timeout = TimeUnit.NANOSECONDS.convert(5, TimeUnit.SECONDS);
        System.out.println("延时时间："+timeout);
        OrderDelay orderDelay = new OrderDelay(orderId,timeout);
        queue.put(orderDelay);
        StopWatch sw = new StopWatch();
        sw.start("jdk延迟队列");
        try {
            OrderDelay take = queue.take();
            System.out.println("获取到延时队列中的数据"+JSON.toJSONString(take));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sw.stop();
        System.out.println("总耗时："+ sw.prettyPrint());
    }
}
