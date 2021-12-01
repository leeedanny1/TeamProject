package com.springboot.jcmarket.domain.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.notice.NoticeInsertDto;

@Mapper
public interface NoticeRepository {
	
//	전체 공지사항 목록 들고오기
	public List<Notice> getNoticeListAll();
//	공지사항 디테일 페이지 가져오기
	public Notice getNoticeDtl(int notice_code);
	
	
//	공지사항 등록
	//마스터테이블 insert. 트리거로 디테일 생성됨.
	public int noticeMstInsert(Notice notice);
	//가장 최근의 code
	public Notice getInsetNoticeCode();
	//생성된 디테일 update.
	public int noticeDtlInsert(Notice notice);
//	공지사항 삭제
	public int noticeDelete(int notice_code);
	
}
