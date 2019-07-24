package com.moozhy.service.impl;

import com.moozhy.dto.OrderDTO;
import com.moozhy.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Amboo Chou on 2018/4/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO=orderService.findOne("123456");
        pushMessageService.orderStatus(orderDTO);

    }
}