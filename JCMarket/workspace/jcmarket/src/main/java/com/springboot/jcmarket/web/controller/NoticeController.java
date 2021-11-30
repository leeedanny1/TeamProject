package com.springboot.jcmarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.web.dto.notice.NoticeDto;
import com.springboot.jcmarket.web.service.NoticeService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	private final NoticeService noticeService;
//	private final NoticeDto noticeDto;
//	private Notice notice;

/*
 * 페이지 연결
 */
	
//	notice 목록 페이지 연결
	@GetMapping("/list")
	public ModelAndView notice(Model model) {
		ModelAndView mav = new ModelAndView("notice/notice");
		model.addAttribute("notice", noticeService.getNoticeAll());
		return mav;
	}
	
//	notice글쓰기 연결
	@GetMapping("/write")
	public String noticeWrite() {
		return "notice/notice_insert";
	}
	
////	notice dtl페이지 연결
//	@GetMapping("/notice/")
//	public String noticeDtl() {
//		// 서비스랑 만들어야됨
//		return "notice/notice_dtl";
//	}
	


	

}
