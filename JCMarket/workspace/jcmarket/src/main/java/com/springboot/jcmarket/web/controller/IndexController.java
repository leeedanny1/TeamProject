package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jcmarket.config.auth.PrincipalDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	@GetMapping({ "/", "/index" })
	public String index(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		
		if(principalDetails != null) {
			if(principalDetails.getUser().getUser_nickname().equals("") || principalDetails.getUser().getUser_nickname() == null ) {
				return "redirect:/logout";
			}
		}
		return "index/index";
	}

	@ResponseBody
	@GetMapping("get-password")
	public String getPassword(@RequestParam String input_password,
			@AuthenticationPrincipal PrincipalDetails principalDetails) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String user_password = principalDetails.getUser().getUser_password();
		System.out.println("input_password: " + input_password);
		System.out.println("user_password: " + user_password);
		if (passwordEncoder.matches(input_password, user_password)) {
			return "1";
		}
		return "2";
	}

}
