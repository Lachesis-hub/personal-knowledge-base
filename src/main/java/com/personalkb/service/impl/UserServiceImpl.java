package com.personalkb.service.impl;

import com.personalkb.dto.LoginDTO;
import com.personalkb.dto.RegisterDTO;
import com.personalkb.entity.User;
import com.personalkb.mapper.UserMapper;
import com.personalkb.service.UserService;
import com.personalkb.utils.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void register(RegisterDTO dto) {

        User exist = userMapper.selectByUsername(dto.getUsername());

        if (exist != null) {
            throw new RuntimeException("用户名已存在");
        }

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(
                PasswordUtil.encode(dto.getPassword())
        );
        user.setNickname(dto.getNickname());

        userMapper.insert(user);
    }

    @Override
    public User login(LoginDTO dto) {

        User user =
                userMapper.selectByUsername(dto.getUsername());

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        if (!PasswordUtil.matches(
                dto.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("密码错误");
        }

        return user;
    }
}