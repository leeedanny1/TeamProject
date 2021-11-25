package com.springboot.jcmarket.web.service;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.domain.user.UserRepository;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthSignUpServiceImpl /* implements AuthSignUpService */ {

	private final UserRepository userrepository;
	/*
	 * @Override public int signup(SignUpDto signupDto) {
	 * 
	 * String user = signupDto.toEntity(); int usernameCheckResult =
	 * userrepository.idCheck(user); return 0;
	 * 
	 * }
	 */

}
