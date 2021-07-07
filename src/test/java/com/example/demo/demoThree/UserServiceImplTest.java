package com.example.demo.demoThree;

import com.example.demo.DemoApplication;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @date 2020/11/16 10:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserServiceImplTest {

    @Autowired
    UserInfoService userService;

    @Test
    @Transactional
    public void insert() {
        UserInfo user = new UserInfo();
        user.setLoginPassword("qwer");
        user.setUserName("qwer");
        user.setId(3);
        userService.insert(user);
        int a = 1/0;
    }

    @Test
    public void selectUser() {
        List<UserInfo> users = userService.list();
        for (UserInfo user : users) {
            System.out.println(user);
        }
    }
}