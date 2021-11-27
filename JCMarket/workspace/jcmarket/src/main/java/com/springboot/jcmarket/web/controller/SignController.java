package com.springboot.jcmarket.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.service.SignUpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SignController {

	private final SignUpService signUpService;
	


	@GetMapping("/sign-in-select")
	public String signInSelect() {
		return "sign_in/sign_in_select";
	}
	@GetMapping("/sign-in")
	public String signIn() {
		return "sign_in/sign_in";
	}
	@GetMapping("/sign-up-social")
	public String signUpSocial(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		if(principalDetails.getUser().getUser_nickname()==null){
			return "sign_up/sign_up_social";
		}else {
		return " redirect:/";
	}
}

	
	@GetMapping("/sign-up")
	public String signUp() {
		return "sign_up/sign_up_dtl";
	}
	

	
	@ResponseBody
	@GetMapping("phone-check")
	public String sendSMS(String phoneNumber) { 
		
		System.out.println(phoneNumber);
		String authenticationCode=null;
		authenticationCode= signUpService.sendAuthenticationCode(phoneNumber);
		return authenticationCode;
	}
	@ResponseBody
	@PostMapping("/id-check")
	public String idCheck(@RequestBody SignUpDto signUpDto) {
		System.out.println(signUpDto);
		return Integer.toString(signUpService.idCheck(signUpDto));
	}

	@ResponseBody
	@GetMapping("nickname-check")
	public String nicknameCheck(@RequestParam String signUpNickname) {

		return Integer.toString(signUpService.nicknameCheck(signUpNickname));
	}

	@ResponseBody
	@PostMapping("sign-up")
	public String signUp(@RequestBody SignUpDto signUpDto, HttpServletRequest request) {
	  return Integer.toString(signUpService.signUp(signUpDto));
	}
}
