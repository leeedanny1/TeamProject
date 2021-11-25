package com.springboot.jcmarket.web.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.domain.user.UserRepository;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthSignUpServiceImpl implements AuthSignUpService  {

	private final UserRepository userrepository;
	
	@Override
	public int signup(SignUpDto signupDto) {
		User user = signupDto.toEntity();
		int usernameCheckResult = userrepository.idCheck(user);
		if(usernameCheckResult == 1) {
			return 2;
		}else {
			user.setUser_password(new BCryptPasswordEncoder().encode(user.getUser_password()));
			user.setRole("General member");
			int signupResult = userrepository.signUp(user);
			return signupResult;
		}
	}
}
