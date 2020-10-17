package com.enjoy.service;

import com.enjoy.entity.UserEntity;

public  interface UserService {

    UserEntity getDetail(String id);
    UserEntity regist(UserEntity user);
    UserEntity recharge(String id, long money);
}