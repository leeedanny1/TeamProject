package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.domain.user.User;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.service.SignUpService;
import com.springboot.jcmarket.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService userService;
	private final SignUpService signUpService;

	@GetMapping("/update")
	public String update() {
		
		return "mypage/user_update";
	}

	
	@ResponseBody
	@PostMapping("/update")
	public String update(@RequestBody SignUpDto signUpDto) {

		User user = signUpService.getUser(signUpDto.getUser_id());
		if (signUpDto.getUser_password() == "") {
			signUpDto.setUser_password(user.getUser_password());
		} else if (signUpDto.getUser_nickname() == "") {
			signUpDto.setUser_nickname(user.getUser_nickname());
		}
		return  Integer.toString(userService.updateUser(signUpDto));
	
      
	}
}
