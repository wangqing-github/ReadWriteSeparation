package com.example.demo.demoTwo;

import com.example.demo.DemoApplication;
import com.example.demo.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={DemoApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoTwo {

    @Test
    void contextLoads() {
        ApplicationContext acp = new ClassPathXmlApplicationContext("spring.xml");
        UserInfoService userService = (UserInfoService) acp.getBean("userService");
        userService.list().forEach(System.out::println);
    }

}
