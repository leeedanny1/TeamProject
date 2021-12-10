package com.springboot.jcmarket.web.service;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.domain.user.UserRepository;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.dto.auth.findAccountDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	@Override
	public int updateUser(SignUpDto signUpDto) {
		User user = signUpDto.toEntity();
		return userRepository.updateUser(user);
	}
	
    @Override
	public User findId(findAccountDto findAccountDto) {
		User user = findAccountDto.toEntity();
		return userRepository.findId(user);
	}


	@Override
	public User findPassword(findAccountDto findAccountDto) {
		User user = findAccountDto.toEntity();
		return userRepository.findPassword(user);
	}
	

	@Override
	public int withdraw(int id) {
		return userRepository.withdraw(id);
	}

	@Override
	public int updatePassword(findAccountDto findAccountDto) {
		User user = findAccountDto.toEntity();
		return userRepository.updatePassword(user);
	}

	@Override
	public String getNickname(int id) {
		return userRepository.getNickname(id);
	}

}
