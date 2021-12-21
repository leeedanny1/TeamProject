package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.dto.auth.findAccountDto;

public interface UserService {

	public int updateUser(SignUpDto signUpDto);

	public User findId(findAccountDto findAccountDto);

	public User findPassword(findAccountDto findAccountDto);

	public int updatePassword(findAccountDto findAccountDto);

	public String getNickname(int id);

	public int withdraw(int id);

}
