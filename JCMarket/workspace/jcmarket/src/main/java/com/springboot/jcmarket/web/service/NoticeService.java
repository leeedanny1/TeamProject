package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.web.dto.notice.GetNoticeDto;

public interface NoticeService {

//	전체 공지사항 가져옴
	public Notice getNoticeAll();

//	공지사항 디테일 페이지
	public Notice getNotice(int notice_code);
}
