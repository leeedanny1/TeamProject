package com.springboot.jcmarket.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
  
	@GetMapping({"/","/index"})
     public String index(HttpServletRequest request ) {
		return "index/index";
     }

	@GetMapping("/logout")
	 public String logout(HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 session.invalidate();
		 
		 return "redirect:index/index";
	 }
	
}
	
