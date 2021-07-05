package com.example.demo;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext acp = new ClassPathXmlApplicationContext("spring.xml");
        UserInfoService userService = (UserInfoService) acp.getBean("userService");
        userService.list();
    }

}
