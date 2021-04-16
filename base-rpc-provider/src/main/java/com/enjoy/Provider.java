package com.enjoy;

import com.alibaba.fastjson.JSON;
import com.enjoy.entity.OrderEntity;
import com.enjoy.service.InfoService;
import com.enjoy.service.InfoServiceImpl;
import com.enjoy.service.OrderService;
import com.enjoy.service.OrderServiceImpl;
import com.enjoy.util.InvokeUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

public class Provider {


    @Configuration
    static class ProviderConfiguration{
        @Bean
        public OrderService orderService(){
            return new OrderServiceImpl();
        }
    }

    public static void main(String[] args) throws IOException, AlreadyBoundException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.out.println("-------Spring 启动成功-------");
        //正常访问orderService
        OrderService orderService = (OrderService)context.getBean("orderService");
        OrderEntity orderEntity = orderService.getDetail("1");
        System.out.println("测试orderService.getDetail调用功能，调用结果：" + JSON.toJSONString(orderEntity));

        System.out.println("-------------------------");
        //通过反射机制调用
        //通过反射机制条用orderService.getDetail
        Map<String,String> paraMap = new HashMap<>();
        paraMap.put("target","orderService");
        paraMap.put("methodName","getDetail");
        paraMap.put("arg","1");
        Object result = InvokeUtils.call(paraMap,context);
        System.out.println("通过InvokeUtils.call调用功能，调用结果：" + JSON.toJSONString(result));

        System.out.println("------------------------");

        //初始化rmi绑定
        initProtocol(context);

        System.in.read();
    }

    //服务暴露
    public static void initProtocol(ApplicationContext ctx) throws RemoteException, AlreadyBoundException, MalformedURLException {
        InfoService infoService = new InfoServiceImpl();
        //注册通讯接口
        LocateRegistry.createRegistry(InfoService.port);
        //注册通讯路径
        Naming.bind(InfoService.RMI_URL, infoService);

        System.out.println("初始化rmi绑定");
    }
}
