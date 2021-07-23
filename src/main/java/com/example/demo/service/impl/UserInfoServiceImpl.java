package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.annotation.Master;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.user.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Override
    public void insert(UserInfo user) {
        baseMapper.insert(user);
    }

    @Override
    @Master(type = 2)
    public void testAnnotation() {
        System.out.println("测试注解");
    }
}
