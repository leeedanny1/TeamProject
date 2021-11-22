package com.springboot.jcmarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.service.SignUpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SignUpController {

	private final SignUpService signUpService;

	@GetMapping("/sign-up")
	public String signUp() {
		return "sign/sign_up_dtl";
	}

	@ResponseBody
	@PostMapping("/phone-check")
	public Object phoneCheck(SignUpDto signUpDto) {
		return signUpService.phoneCheck(signUpDto);
	}

	@ResponseBody
	@GetMapping("/id-check")
	public String idCheck(@RequestParam String signUpId) {
		 return Integer.toString(signUpService.idCheck(signUpId));
	}
	
	@ResponseBody
	@GetMapping("nickname-check")
	public String nicknameCheck(@RequestParam String signUpNickname) {
		System.out.println(signUpNickname);
		return Integer.toString(signUpService.nicknameCheck(signUpNickname));
	}
}
