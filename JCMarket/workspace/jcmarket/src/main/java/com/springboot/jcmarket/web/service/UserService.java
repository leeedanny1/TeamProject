package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.web.dto.auth.SignUpDto;

public interface UserService {
   public int updateUser(SignUpDto signUpDto);
}
