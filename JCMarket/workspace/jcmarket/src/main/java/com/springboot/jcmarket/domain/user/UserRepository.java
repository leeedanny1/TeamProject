package com.springboot.jcmarket.domain.user;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.auth.SignUpDto;

@Mapper
public interface UserRepository {
	  public int phoneCheck(SignUpDto signUpDto);
	  public int idCheck(String signUpId);
	  public int nicknameCheck(String signUpNickname);
	  public int signUp(User user);
<<<<<<< HEAD
	  public User getUser(String user_id);

=======
	  public User getUser(String signUpEmail);
>>>>>>> 09b81f3ec0b37c6026bea4c359d5b3b3ed0842cd
}
