package com.personalkb.mapper;

import com.personalkb.entity.User;

public interface UserMapper {

    User selectByUsername(String username);

    int insert(User user);

}