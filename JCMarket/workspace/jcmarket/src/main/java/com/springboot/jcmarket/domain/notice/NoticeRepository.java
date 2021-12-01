package com.springboot.jcmarket.domain.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeRepository {
	
//	전체 공지사항 목록 들고오기
	public List<Notice> getNoticeListAll();
//	공지사항 디테일 페이지 가져오기
	public Notice getNoticeDtl(int notice_code);
	
}
