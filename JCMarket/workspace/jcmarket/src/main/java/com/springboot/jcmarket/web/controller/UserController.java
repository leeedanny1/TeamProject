package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PutMapping("/update")
	public String update(@RequestBody SignUpDto signUpDto , @AuthenticationPrincipal PrincipalDetails prDetails) {
		User user = signUpService.getUser(signUpDto.getUser_id());
		int update=signUpService.socailupdate(signUpDto);
		if (signUpDto.getUser_password() == "") {
			signUpDto.setUser_password(user.getUser_password());
		} else if (signUpDto.getUser_nickname() == "") {
			signUpDto.setUser_nickname(user.getUser_nickname());
		}
		if(update==1) {
			
			  prDetails.getUser().setUser_nickname(signUpDto.getUser_nickname());
			  prDetails.getUser().setUser_phone(signUpDto.getUser_phone());		
		}
		return  Integer.toString(userService.updateUser(signUpDto));
	
	}
	
	@ResponseBody
	@DeleteMapping("/withdraw")
	public String withdraw(@AuthenticationPrincipal PrincipalDetails principalDetails) {
		System.out.println(principalDetails.getUser().getId());
		return Integer.toString(userService.withdraw(principalDetails.getUser().getId()));
	}
}
