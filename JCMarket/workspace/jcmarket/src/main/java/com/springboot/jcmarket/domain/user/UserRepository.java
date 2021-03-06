package com.springboot.jcmarket.domain.user;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.auth.SignUpDto;

@Mapper
public interface UserRepository {
	public int phoneCheck(SignUpDto signUpDto);

	public int idCheck(User user);

	public int nicknameCheck(String signUpNickname);

	public int signUp(User user);

	public User findId(User user);

	public User findPassword(User user);

	public int updatePassword(User user);

	public User getUser(String user_id);

	public String getNickname(int id);

	public int updateUser(User user);

	public int socailupdate(User user);

	public int withdraw(int id);
}
