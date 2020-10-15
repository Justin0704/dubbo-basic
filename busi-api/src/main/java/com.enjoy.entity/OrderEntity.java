package com.enjoy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderEntity implements Serializable{
    private String id;
    private long money;
    private String userId;
    private int status = 0;
    private List<ProductEntity> productlist = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ProductEntity> getProductlist() {
        return productlist;
    }

    public void setProductlist(List<ProductEntity> productlist) {
        this.productlist = productlist;
    }
}
