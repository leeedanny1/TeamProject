package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;

public interface SignUpService {

	  public int phoneCheck(SignUpDto signUpDto);
	  public int idCheck(String SignUpId);
	  public int nicknameCheck(String signUpNickname);	
	  public int signUp(SignUpDto signUpDto);
	  public User getUser(String user_id);
	  public String createAuthenticationCode();
	  public String  sendAuthenticationCode(String phoneNumber);
}
