package com.springboot.jcmarket.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jcmarket.web.dto.notice.NoticeDto;
import com.springboot.jcmarket.web.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/notice")
@RestController
public class NoticeRestController {
	
	private final NoticeService noticeService;

	
//	notice 등록
	@PostMapping("/insert")
	public String noticeInsert(NoticeDto noticeDto) {
		return Integer.toString(noticeService.noticeInsert(noticeDto));
	}
	
//	notice 수정
	@PutMapping("/update")
	public String noticeUpdate(NoticeDto noticeDto) {
		System.out.println(noticeDto);
		return Integer.toString(noticeService.noticeUpdate(noticeDto));
	}
	
//	notice 삭제
	@DeleteMapping("/delete/{notice_code}")
	public String noticeDelete(Model model, @PathVariable int notice_code) {
		return Integer.toString(noticeService.noticeDelete(notice_code)); 
	}
}
