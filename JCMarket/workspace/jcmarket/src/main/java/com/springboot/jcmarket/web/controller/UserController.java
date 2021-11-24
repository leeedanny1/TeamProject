package com.springboot.jcmarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/update")
	public String update() {
		return "mypage/user_update";
	}
}
