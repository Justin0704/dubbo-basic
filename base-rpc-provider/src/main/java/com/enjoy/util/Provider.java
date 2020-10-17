package com.enjoy.util;

import com.alibaba.fastjson.JSON;
import com.enjoy.entity.OrderEntity;
import com.enjoy.service.OrderService;
import com.enjoy.service.OrderServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public class Provider {


    @Configuration
    static class ProviderConfiguration{
        @Bean
        public OrderService orderService(){
            return new OrderServiceImpl();
        }
    }

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.out.println("-------Spring 启动成功-------");

        OrderService orderService = (OrderService)context.getBean("orderService");
        OrderEntity orderEntity = orderService.getDetail("1");
        System.out.println("测试orderService.getDetail调用功能，调用结果：" + JSON.toJSONString(orderEntity));

        System.in.read();
    }
}
