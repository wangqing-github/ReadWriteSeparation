package com.example.demo.demoOne;

import com.example.demo.DemoApplication;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.SpringContext;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={DemoApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoOne {

    @Test
    void contextLoads() {
        UserInfoService userInfoService = (UserInfoService) SpringContext.inst().getInterfaceBeans(UserInfoService.class);
        List<UserInfo> list = userInfoService.list();
        list.forEach(System.out::println);
    }

}
