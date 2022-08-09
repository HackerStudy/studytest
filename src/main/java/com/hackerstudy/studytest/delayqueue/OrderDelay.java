package com.hackerstudy.studytest.delayqueue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Class: OrderDelay
 * @Description: 订单的延时数据
 * @Author: hacker
 * @Date: 2022-07-22 17:04
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDelay implements Delayed {

    //订单id
    private Long orderId;

    //超时时间的时间戳
    private long timeout;

    /**
     * 返回距离超时时间还有多少时间
     * @param unit the time unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    /**
     * 对BlockingQueue（无界阻塞队列）中元素进行排序
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }

        OrderDelay orderDelay = (OrderDelay) o;

        long d = (getDelay(TimeUnit.NANOSECONDS) -
                orderDelay.getDelay(TimeUnit.NANOSECONDS));

        return (d == 0) ? 0 : ((d < 0) ? (-1) : 1);
    }

}
