package com.springboot.jcmarket.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.web.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	private final NoticeService noticeService;

	
//	notice 목록 페이지 연결
	@GetMapping("/list")
	public ModelAndView notice() {
		ModelAndView mav = new ModelAndView("notice/notice");
		mav.addObject("noticeList", noticeService.getNoticeListAll());
		return mav;
	}
//	목록 번호 만들어서 일정 갯수씩 출력
//	@GetMapping("/list/{page}")
//	public ModelAndView notice(@PathVariable int page) {
//		ModelAndView mav = new ModelAndView("notice/notice");
//		mav.addObject("noticeList", noticeService.getNoticeList());
//		return mav;
//	}
	
//	notice dtl페이지 연결
	@GetMapping("/{notice_code}")
	public ModelAndView noticeDtl(@PathVariable int notice_code) {
		ModelAndView mav = new ModelAndView("notice/notice_dtl");
		mav.addObject("notice_dtl", noticeService.getNoticeDtl(notice_code));
		return mav;
	}
	
//	notice글쓰기 연결
	@GetMapping("/insert")
	public String noticeWrite(Model model) {
		
		Date date = new Date();
		model.addAttribute("now", date);
		return "notice/notice_insert";
	}
	
//	notice 수정
	@GetMapping("/update/{notice_code}")
	public ModelAndView noticeUpdate(Model model, @PathVariable int notice_code) {
		Date date = new Date();
		model.addAttribute("now", date);
		ModelAndView mav = new ModelAndView("notice/notice_update");
		mav.addObject("notice_update", noticeService.getNoticeDtl(notice_code));
		return mav;
	}
	
	
	

	

	


	

}
