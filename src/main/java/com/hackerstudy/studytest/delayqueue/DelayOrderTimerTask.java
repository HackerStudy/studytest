package com.hackerstudy.studytest.delayqueue;

import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * @class: DelayOrderTimerTask
 * @description:
 * @author: 17911
 * @date: 2022-07-24 10:55
 */
@Data
@Slf4j
public class DelayOrderTimerTask implements TimerTask {

    boolean flag = true;

    private DelayOrderQry delayOrderQry;

    @Override
    public void run(Timeout timeout) throws Exception {
        StopWatch sw = new StopWatch();
        sw.start("延迟队列（TimerTask）");
        log.info("取消订单：orderId={}",delayOrderQry.getOrderId());
        flag = false;
        sw.stop();
        log.debug("延迟任务处理耗时：{}", sw.prettyPrint());
    }

}
