package com.enjoy.util;

import com.alibaba.fastjson.JSON;
import com.enjoy.service.InfoService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class RmiClient {

    public static void main(String[] args){

        InfoService infoService = null;

        try {
            //获取远程服务实现
            infoService = (InfoService) Naming.lookup(InfoService.RMI_URL);
            Object ret = infoService.sayHello("justin");
            System.out.println("测试远程调用功能infoService.sayHello，调用结果：" + JSON.toJSONString(ret));

            //呼叫远程反射方法
            Map<String,String> info = new HashMap();
            info.put("target","orderService");
            info.put("methodName","getDetail");
            info.put("arg","1");
            Object result = infoService.passInfo(info);
            System.out.println("测试远程调用功能，调用结果：" + JSON.toJSONString(result));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
