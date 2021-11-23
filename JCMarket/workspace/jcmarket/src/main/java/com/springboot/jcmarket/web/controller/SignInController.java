package com.springboot.jcmarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInController {
	@RequestMapping(value="sign-in" ,method = RequestMethod.GET)
	public String index() {
		return "sign_in/sign_in";
	}
}
