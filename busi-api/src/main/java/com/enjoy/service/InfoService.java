package com.enjoy.service;

import java.rmi.RemoteException;
import java.util.Map;

public interface InfoService {
    String RMI_URL = "rmi://127.0.0.1:9080/InfoService";
    int port = 9080;

    Object sayHello(String name) throws RemoteException;
    Object passInfo(Map<String,String> info) throws RemoteException;
}
