package com.springboot.jcmarket.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.service.SignUpService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {

	private final SignUpService signUpService;

	@GetMapping("/sign_in")
	public String signIn() {
		return "sign_in/sign_in";
	}

	
	@GetMapping("/sign-up")
	public String signUp() {
		return "sign_up/sign_up_dtl";
	}

	@ResponseBody
	@PostMapping("/phone-check")
	public String phoneCheck(@RequestBody SignUpDto signUpDto) {

		return Integer.toString(signUpService.phoneCheck(signUpDto));
	}

	@ResponseBody
	@GetMapping("/id-check")
	public String idCheck(@RequestParam String signUpId) {
		return Integer.toString(signUpService.idCheck(signUpId));
	}

	@ResponseBody
	@GetMapping("nickname-check")
	public String nicknameCheck(@RequestParam String signUpNickname) {

		return Integer.toString(signUpService.nicknameCheck(signUpNickname));
	}

	@ResponseBody
	@PostMapping("sign-up")
	public String signUp(@RequestBody SignUpDto signUpDto, HttpServletRequest request) {
		int result = signUpService.signUp(signUpDto);
		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("login_user", signUpService.getUser(signUpDto.getUser_id()));
		}

		return Integer.toString(result);
	}


}
