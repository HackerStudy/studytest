package com.hackerstudy.studytest.delayqueue;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @class: Order
 * @description: 延迟订单参数
 * @author: 17911
 * @date: 2022-08-13 10:52
 */
@Data
@Builder
public class DelayOrderQry implements Serializable {

    /** 订单id*/
    private Long orderId;

}
