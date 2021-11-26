package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.web.dto.notice.NoticeDto;
import com.springboot.jcmarket.web.dto.notice.NoticeInsertDto;

public interface NoticeService {
	
	public NoticeDto getNotice(String notice_code);
	
	public int getNoticeMaxCode();
	public void plusNoticeCount(String notice_code);
	
	
	public int noticeInsert(NoticeInsertDto noticeInsertDto); 
	
	
	
	
	

}
