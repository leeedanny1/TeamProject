package com.springboot.jcmarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.jcmarket.web.dto.notice.NoticeDto;
import com.springboot.jcmarket.web.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	private final NoticeService noticeService;
//	private final NoticeDto noticeDto;

/*
 * 페이지 연결
 */
	
//	notice 페이지 연결
	@GetMapping("/notice")
	public String notice(/*Model model*/) {
//		model.addAttribute("notice", noticeDto);
		return "notice/notice";
	}
	
//	notice글쓰기 연결
	@GetMapping("/write")
	public String noticeWrite() {
		return "notice/notice_insert";
	}
	


	

}
