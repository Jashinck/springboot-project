package com.moozhy.service;

import com.moozhy.dto.OrderDTO;

/**
 * 推送消息
 * @author Amboo Chou on 2018/4/2.
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
