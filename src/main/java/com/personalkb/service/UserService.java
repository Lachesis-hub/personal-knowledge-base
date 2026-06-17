package com.personalkb.service;

import com.personalkb.dto.LoginDTO;
import com.personalkb.dto.RegisterDTO;
import com.personalkb.entity.User;

public interface UserService {

    void register(RegisterDTO dto);

    User login(LoginDTO dto);

}