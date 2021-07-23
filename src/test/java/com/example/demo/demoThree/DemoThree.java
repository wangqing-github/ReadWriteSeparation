package com.example.demo.demoThree;

import com.example.demo.DemoApplication;
import com.example.demo.annotation.Master;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.Builder;
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
public class DemoThree {

    @Autowired
    UserInfoService userService;

    @Test
    public void insert() {
        //每天一个装杯小技巧
        UserInfo user = Builder.of(UserInfo::new).
                with(UserInfo::setLoginName, "小王").
                with(UserInfo::setAge, 18).
                with(UserInfo::setUserName, "小王").build();
        userService.insert(user);
    }

    @Test
    public void selectUser() {
        List<UserInfo> users = userService.list();
        for (UserInfo user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAnnotation() {
        userService.testAnnotation();
    }
}