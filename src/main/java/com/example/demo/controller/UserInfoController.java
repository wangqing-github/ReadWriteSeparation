package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.utils.ResultMsg;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/list")
    @ApiOperation(value = "查找用户列表", httpMethod = "POST")
    public ResultMsg login() {
        List<UserInfo> list = userInfoService.list();
        return ResultMsg.success(list);
    }

}
