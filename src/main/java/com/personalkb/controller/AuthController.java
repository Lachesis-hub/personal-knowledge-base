package com.personalkb.controller;

import com.personalkb.common.Result;
import com.personalkb.dto.LoginDTO;
import com.personalkb.dto.RegisterDTO;
import com.personalkb.entity.User;
import com.personalkb.service.UserService;
import com.personalkb.utils.JwtUtil;
import com.personalkb.vo.LoginVO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result<?> register(
            @RequestBody @Valid RegisterDTO dto) {

        userService.register(dto);

        return Result.success();
    }

    @PostMapping("/login")
    public Result<LoginVO> login(
            @RequestBody @Valid LoginDTO dto) {

        User user = userService.login(dto);
        String token =
                JwtUtil.generateToken(user.getId());
        LoginVO vo = new LoginVO();

        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setNickname(user.getNickname());
        vo.setToken(token);

        return Result.success(vo);
    }
}