package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.user.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectList() {
        return userInfoMapper.list();
    }

    @Override
    public void insert(UserInfo user) {
        userInfoMapper.insert(user);
    }
}
