package com.springboot.jcmarket.web.service;

import java.util.List;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.web.beans.NoticeBean;
import com.springboot.jcmarket.web.dto.notice.NoticeDto;

public interface NoticeService {

//	전체 공지사항 가져옴
	// 모든 공지사항을 가져와서
	public List<Notice> getNoticeListAll();
	// 원하는 갯수만큼 담는 리스트를 위한 bean
	public NoticeBean getNoticeBean();
	public void setNoticeBean(int pageNumber);
	// 페이지 넘버
	public int parseIntPageNumber(int pagenumber);
	// 원하는 갯수만큼 노출
	public List<Notice> getNoticeList(int pageNumber);
	
//	공지사항 조회수 증가
	public void plusNoticeCount(int notice_code);
	
//	공지사항 디테일 페이지
	public Notice getNoticeDtl(int notice_code);
	
//	공지사항 등록
	public int noticeInsert(NoticeDto noticeDto);
	
//	공지사항 수정
	public int noticeUpdate(NoticeDto noticeDto);
	
//	공지사항 삭제
	public int noticeDelete(int notice_code);
}
