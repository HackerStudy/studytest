package com.hackerstudy.studytest.delayqueue.main;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.hackerstudy.studytest.delayqueue.DelayOrderQry;
import com.hackerstudy.studytest.delayqueue.DelayTask;
import com.hackerstudy.studytest.enums.DelayTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @Class: DelayQueueMain
 * @Description:
 * @Author: NING MEI
 * @Date: 2022-07-22 17:15
 * @Version: 1.0
 */
@Slf4j
public class DelayQueueMain {
    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-delayQueue").build();

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), threadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static DelayQueue<DelayTask> delayQueue = new DelayQueue<>();

    public static void main(String[] args) {
        //生产者往延迟队列中放数据
        producer();

        //消费延迟队列中的数据
        consumer();
    }

    /**
     * 生产者
     */
    private static void producer() {

        //模拟5个延迟任务
        for (int i = 0; i < 5; i++) {
            DelayOrderQry qry = DelayOrderQry.builder()
                    .orderId((long) i)
                    .build();
            //延迟5秒
            long timeout = TimeUnit.NANOSECONDS.convert(5, TimeUnit.SECONDS);
            DelayTask<DelayOrderQry> delayTask = new DelayTask<>(qry, DelayTypeEnum.order.getCode(),param -> {
                //取消订单
                DelayOrderQry delayOrderQry = param;
                log.info("开始取消订单 orderId={}", JSON.toJSONString(delayOrderQry));
                return "";
            },timeout);
            delayQueue.put(delayTask);
            log.info("放入延迟队列（order）：taskParam={},type={},timeout={}",delayTask.getTaskParam(),delayTask.getType(),delayTask.getTimeout());
        }

    }

    private static void consumer(){
        while (true) {
            if (0==delayQueue.size()) {
                break;
            }
            try {
                //从延迟队列中取值,如果没有对象过期则取到null
                DelayTask delayTask = delayQueue.poll();
                if (Objects.nonNull(delayTask)) {
                    threadPool.execute(delayTask);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
