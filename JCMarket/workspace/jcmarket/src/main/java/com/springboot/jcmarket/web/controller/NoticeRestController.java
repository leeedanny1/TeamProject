package com.springboot.jcmarket.web.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jcmarket.web.beans.FileBean;
import com.springboot.jcmarket.web.dto.notice.NoticeDto;
import com.springboot.jcmarket.web.dto.notice.NoticeInsertDto;
import com.springboot.jcmarket.web.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/notice")
@RestController
public class NoticeRestController {

	private final NoticeService noticeService;

//	파일 다운로드
	@GetMapping("/file-download/{originFileName}")
	public byte[] noticeDtlFileDownload(HttpServletResponse response, @PathVariable String originFileName,
			@RequestParam String tempFileName) {

		FileBean fileBean = new FileBean();
		fileBean.setOriginFileName(originFileName);
		fileBean.setTempFileName(tempFileName);

		byte[] fileData = noticeService.fileDownload(fileBean);

		String encodingOriginFileName = null;
		try {
			encodingOriginFileName = new String(originFileName.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;filename=\"" + encodingOriginFileName + "\"");
		response.setContentLength(fileData.length);

		return fileData;
	}

//	notice 등록
	@PostMapping("/insert")
	public String noticeInsert(NoticeInsertDto noticeInsertDto) {
		return Integer.toString(noticeService.noticeInsert(noticeInsertDto));
	}

//	notice 수정
	@PutMapping("/update")
	public String noticeUpdate(NoticeDto noticeDto) {
		return Integer.toString(noticeService.noticeUpdate(noticeDto));
	}

//	notice 삭제
	@DeleteMapping("/delete/{notice_code}")
	public String noticeDelete(Model model, @PathVariable int notice_code) {
		return Integer.toString(noticeService.noticeDelete(notice_code));
	}
}
