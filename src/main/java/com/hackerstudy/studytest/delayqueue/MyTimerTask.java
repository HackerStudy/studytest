package com.hackerstudy.studytest.delayqueue;

import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @class: MyTimerTask
 * @description:
 * @author: 17911
 * @date: 2022-07-24 10:55
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class MyTimerTask implements TimerTask {

    //订单id
    private Long orderId;

    @Override
    public void run(Timeout timeout) throws Exception {
        //处理超时的订单
        log.info("超时订单：{}",orderId);
    }

}
