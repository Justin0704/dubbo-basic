package com.enjoy.service;

import com.enjoy.entity.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public OrderEntity getDetail(String id) {
        System.out.println(super.getClass().getName() + "被调用一次：" + System.currentTimeMillis());
        OrderEntity orderEntiry = new OrderEntity();
        orderEntiry.setId("O0001");
        orderEntiry.setMoney(1000);
        orderEntiry.setUserId("U0001");
        return orderEntiry;
    }
}
