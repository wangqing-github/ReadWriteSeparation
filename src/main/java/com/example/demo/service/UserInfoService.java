package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserInfo;

import java.util.List;

public interface UserInfoService extends IService<UserInfo> {
    List<UserInfo> selectList();

    void insert(UserInfo user);
}
