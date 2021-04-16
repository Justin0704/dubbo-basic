package com.enjoy;

import com.alibaba.fastjson.JSON;
import com.enjoy.entity.OrderEntity;
import com.enjoy.service.InfoService;
import com.enjoy.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Consumer {

    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        ctx.start();
        //No bean named 'orderService' available(没有orderService实例)
        OrderService orderService = (OrderService)ctx.getBean("orderService");
        OrderEntity orderEntity = orderService.getDetail("1");
        System.out.println("测试orderService.getDetail调用功能，调用结果：" + JSON.toJSONString(orderEntity));



    }



    @Configuration
    static class ConsumerConfiguration{

        @Bean
        public InfoService infoService(){
            return null;
        }
    }
}
