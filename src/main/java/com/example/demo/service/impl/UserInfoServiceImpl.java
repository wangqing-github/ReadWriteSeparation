package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.SpringContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;
    private JdbcTemplate jdbcTemplate;
    //设置数据源
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        UserInfoService userInfoService = (UserInfoService) SpringContext.inst().getInterfaceBeans(UserInfoService.class);
//        ApplicationContext acp = new ClassPathXmlApplicationContext("spring.xml");
//        UserInfoService userService = (UserInfoService) acp.getBean("userService");
        List<UserInfo> list = userInfoService.list();
        list.forEach(System.out::println);
    }
}
