package com.personalkb.controller;

import com.personalkb.common.Result;
import com.personalkb.entity.User;
import com.personalkb.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final UserMapper userMapper;

    public TestController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/test")
    public Result<User> test() {

        User user = userMapper.selectByUsername("admin");

        return Result.success(user);
    }
}