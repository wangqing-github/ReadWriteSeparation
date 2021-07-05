package com.example.demo.entity;

import com.example.demo.utils.Builder;
import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String loginName;
    private String loginPassword;
    private String userName;
    private int sex;
    private int age;
    private String phone;
    private String work;
    private String address;
    private long birthday;
    private int payMoney;
    private int balance;
    private long createTime;

    public static void main(String[] args) {
        UserInfo userInfo = Builder.of(UserInfo::new).
                with(UserInfo::setId,1).
                with(UserInfo::setUserName,"小王").build();
        System.out.println(userInfo.getId()+"   "+userInfo.getUserName());
    }
}