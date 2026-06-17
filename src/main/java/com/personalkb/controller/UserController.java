package com.personalkb.controller;

import com.personalkb.common.Result;
import com.personalkb.utils.UserContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Result<Long> me() {

        return Result.success(
                UserContext.get()
        );
    }
}