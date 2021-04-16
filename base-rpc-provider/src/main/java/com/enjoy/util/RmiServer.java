package com.enjoy.util;

import com.enjoy.service.InfoService;
import com.enjoy.service.InfoServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
    public static void main(String[] args) {
        try {
            InfoService infoService = new InfoServiceImpl();
            //注册通讯接口
            LocateRegistry.createRegistry(InfoService.port);
            //注册通讯路径
            Naming.bind(InfoService.RMI_URL,infoService);//服务提供方吧infoService对象绑定到rmi

            System.out.println("初始化rmi绑定。。。。");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
