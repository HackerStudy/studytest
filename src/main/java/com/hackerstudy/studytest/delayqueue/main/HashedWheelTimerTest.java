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

    /**
     * 超时任务3000毫秒，超时之后，由hashedWheelTimer类中的worker线程，执行超时之后的任务。
     * hashedWheelTimer有512个槽（相当于一个圆的512分之一），每移动一个槽的时间是100毫秒。
     * 任务需要经过的tick数为：3000/100=30次。             (等待时长/tickDuration)
     * 任务需要经过的轮数为：10次/512次/轮=0轮。             (tick总次数/ticksPerWheel)
     * 因为任务超时后不能马上被worker线程执行，需要等worker线程移到相应卡槽位置时才会执行，因此说执行时间不精确。
     * hashedWheelTimer的核心是Worker线程，主要负责每过tickDuration时间就累加一次tick。
     * 同时，也负责执行到期的timeout任务，此外，还负责添加timeout任务到指定的wheel中。
     */
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
