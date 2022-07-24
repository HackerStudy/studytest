package com.hackerstudy.studytest.delayqueue.main;

import com.hackerstudy.studytest.delayqueue.MyTimerTask;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timer;

import java.util.concurrent.TimeUnit;

/**
 * @class: HashedWheelTimerTest
 * @description: netty的时间轮来实现延迟队列
 * @author: 17911
 * @date: 2022-07-24 11:00
 */
public class HashedWheelTimerTest {

    public static void main(String[] args) {
        Long orderId = 1L;
        MyTimerTask timerTask = MyTimerTask.builder()
                .orderId(orderId)
                .build();
        Timer timer = new HashedWheelTimer();
        timer.newTimeout(timerTask, 3, TimeUnit.SECONDS);
    }
}
