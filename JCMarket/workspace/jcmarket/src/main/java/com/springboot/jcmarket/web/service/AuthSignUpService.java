package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.web.dto.auth.SignUpDto;

public interface AuthSignUpService {
	public int signup(SignUpDto signupDto);
}
