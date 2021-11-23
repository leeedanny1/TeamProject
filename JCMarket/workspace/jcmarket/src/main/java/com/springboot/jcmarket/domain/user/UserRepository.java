package com.springboot.jcmarket.domain.user;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.auth.SignUpDto;

@Mapper
public interface UserRepository {
	  public int phoneCheck(SignUpDto signUpDto);
	  public int idCheck(String signUpId);
	  public int nicknameCheck(String signUpNickname);
	  public int signUp(User user);
	  public User getUser(String signUpEmail);
}
