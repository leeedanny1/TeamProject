package com.springboot.jcmarket.domain.notice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeRepository {
	
//	전체 공지사항 목록 들고오기
	public Notice getNoticeAll();
//	공지사항 디테일 페이지 가져오기
	public Notice getNotice(int notice_code);
	
}
