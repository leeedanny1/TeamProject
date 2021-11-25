package com.springboot.jcmarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")
@Controller
public class NoticeController {

//	notice 페이지 연결
	@GetMapping("/notice")
	public String notice() {
		return "notice/notice";
	}
	
}
