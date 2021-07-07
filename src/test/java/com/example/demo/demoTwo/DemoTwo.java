package com.example.demo.demoTwo;

import com.example.demo.DemoApplication;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.impl.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class DemoTwo {
    @Autowired
    UserInfoService userInfoService;

    @Test
    public void contextLoads() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentDao dao = (StudentDao) applicationContext.getBean("studentDao");
        List<Map<String, Object>> re = dao.select();
        re.forEach(System.out::println);
        ((ConfigurableApplicationContext) applicationContext).close();
    }
}
