package com.springboot.jcmarket.web.service;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.domain.user.UserRepository;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService{

	private final UserRepository userRepository;

	@Override
	public int phoneCheck(SignUpDto signUpDto) {
		return userRepository.phoneCheck(signUpDto);
	}

	@Override
	public int idCheck(String SignUpId) {
		return userRepository.idCheck(SignUpId);
	}

	@Override
	public int nicknameCheck(String signUpNickname) {
		return userRepository.nicknameCheck(signUpNickname);
	}

	@Override
	public int signUp(SignUpDto signUpDto) {
		User user = signUpDto.toEntity();
		user.setRole("ROLE_USER");
		System.out.println(user);
		return userRepository.signUp(user);
	}

	
   
	

}

