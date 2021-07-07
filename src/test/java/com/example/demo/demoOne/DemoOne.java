package com.example.demo.demoOne;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
@SpringBootTest
public class DemoOne {

    @Test
    public void jdbcTest() {
        String localUrl = "jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
        String localUser = "root";
        String localPassword = "root12345";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(localUrl, localUser, localPassword);
            Statement stmt = conn.createStatement();
            String sql = "select * from user_info";
            ResultSet resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
