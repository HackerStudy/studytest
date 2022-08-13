package com.hackerstudy.studytest.delayqueue.main;

import com.hackerstudy.studytest.delayqueue.DelayOrderQry;
import com.hackerstudy.studytest.delayqueue.DelayOrderTimerTask;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @class: HashedWheelTimerTest
 * @description: netty的时间轮来实现延迟队列
 * @author: 17911
 * @date: 2022-07-24 11:00
 */
@Slf4j
public class HashedWheelTimerTest {

    /**
     * 构建HashedWheelTimer时间轮
     * <p>
     * threadFactory：创建处理任务的线程工厂
     * tickDuration：100 ，表示每个时间格代表当前时间轮的基本时间跨度，这里是100ms，也就是指针100ms跳动一次，每次跳动一个窗格
     * ticksPerWheel：512，表示时间轮上一共有多少个时间格，分配的时间格越多，占用内存空间就越大
     * leakDetection：是否开启内存泄漏检测
     * maxPendingTimeouts[可选参数]，最大允许等待的任务数，默认没有限制
     * <p>
     * 最后通过newTimeout()把需要延迟执行的任务添加到时间轮中
     */
    private static Timer timer = new HashedWheelTimer(
            new DefaultThreadFactory("netty-HashedWheelTimer"),
            100,
            TimeUnit.MILLISECONDS,
            512,
            true);

    public static void main(String[] args) {
        Timeout timeout = product();

        //等待线程,test使用
        waitThread(timeout);
    }

    private static void waitThread(Timeout timeout) {
        DelayOrderTimerTask task = (DelayOrderTimerTask) timeout.task();
        int i = 1;
        while (task.isFlag()){
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            log.debug("{}秒过去了",i);
            i++;
        }
    }

    /**
     * 将取消订单的任务放入时间轮
     */
    private static Timeout product() {
        DelayOrderQry qry = DelayOrderQry.builder()
                .orderId(1L)
                .build();
        DelayOrderTimerTask timerTask = new DelayOrderTimerTask();
        timerTask.setDelayOrderQry(qry);
        //3秒后执行
        return timer.newTimeout(timerTask, 3, TimeUnit.SECONDS);
    }
}
