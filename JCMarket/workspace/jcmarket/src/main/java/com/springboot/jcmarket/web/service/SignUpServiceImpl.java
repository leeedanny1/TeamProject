package com.springboot.jcmarket.web.service;



import java.util.HashMap;
import java.util.Random;
import java.util.HashMap;
import java.util.Random;


import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.domain.user.UserRepository;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;

import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService{

	private final UserRepository userRepository;
	private final String API_KEY="NCS2W4TTYRCVBYM7";
	private final String API_SECRET="8F7FRPZ5QPWDQQOZZMWRNJIDWFXGVN54";

	@Override
	public int phoneCheck(SignUpDto signUpDto) {

		return userRepository.phoneCheck(signUpDto);
	}

	@Override
	public int idCheck(SignUpDto signUpDto) {
		User user = signUpDto.toEntity();
		return userRepository.idCheck(user);
	}

	@Override
	public int nicknameCheck(String signUpNickname) {
		return userRepository.nicknameCheck(signUpNickname);
	}

	@Override
	public int signUp(SignUpDto signUpDto) {
		User user = signUpDto.toEntity();
		user.setRole("ROLE_USER");

		return userRepository.signUp(user);
	}

	@Override
	public User getUser(String user_id) {
		return userRepository.getUser(user_id);
	}

	@Override
	public String createAuthenticationCode() {
		String authenticationCode =""; 
		
		Random randNumber = new Random();
		int codeLength=6;
		for(int i =0;i<codeLength ; i++) {
			String randCode = Integer.toString(randNumber.nextInt(10));
			authenticationCode+=randCode;
		}
		return authenticationCode;
	}
	
	@Override
	public String  sendAuthenticationCode(String phoneNumber) {
		Message coolsms = new Message(API_KEY, API_SECRET);
		String authenticationCode=createAuthenticationCode();
		HashMap<String , String> params= new HashMap<String,String>();
		params.put("to", phoneNumber);//누구에게
		params.put("from","01034012679");//누가 보낼거냐?
		params.put("type", "SMS");
		params.put("text", "jc마켓 가입 인증번호 "+authenticationCode+" 입니다");
		params.put("app_version", "jcmarket app 1.1");
		
		try {
			coolsms.send(params);
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}
		
		return authenticationCode;
	}

}

