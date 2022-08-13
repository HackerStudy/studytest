package com.hackerstudy.studytest.delayqueue;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Class: DelayTask
 * @Description: 延时任务
 * @Author: hacker
 * @Date: 2022-07-22 17:04
 * @Version: 1.0
 */
@Data
@Slf4j
@NoArgsConstructor
public class DelayTask<T> implements Delayed,Runnable {

    /**
     * 当前时间（纳秒）
     */
    private long nowTime = System.nanoTime();

    /**
     * 任务参数
     */
    private T taskParam;

    /**
     * 任务类型
     */
    private Integer type;

    /**
     * 任务函数
     */
    private Function<T, String> function;

    /**
     * 延迟时间(纳秒)
     */
    private long timeout;

    public DelayTask(T taskParam, Integer type, Function<T, String> function,long timeout) {
        this.taskParam = taskParam;
        this.type = type;
        this.function = function;
        this.timeout = nowTime+timeout;
    }

    /**
     * 获取剩余时间
     * @param unit the time unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    /**
     * 比较延时，队列里元素的排序依据
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }
        DelayTask orderDelay = (DelayTask) o;
        long d = (getDelay(TimeUnit.NANOSECONDS) -
                orderDelay.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? (-1) : 1);
    }


    @Override
    public void run() {
        if (Objects.nonNull(taskParam)) {
            log.info("获取到要处理的数据：{}", JSON.toJSONString(taskParam));
            function.apply(taskParam);
        }
    }
}
