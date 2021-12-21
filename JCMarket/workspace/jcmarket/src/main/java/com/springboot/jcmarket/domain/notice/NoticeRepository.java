package com.springboot.jcmarket.domain.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.notice.NoticePreNextDto;

@Mapper
public interface NoticeRepository {

//	전체 공지사항 목록 들고오기
	public List<Notice> getNoticeListAll();

//	공지사항 조회수 증가
	public int plusNoticeCount(int nitice_code);

//	공지사항 디테일 페이지 가져오기
	public Notice getNoticeDtl(int notice_code);

	// 이전글
	public NoticePreNextDto getPreNotice(int notice_code);

	// 다음글
	public NoticePreNextDto getNextNotice(int notice_code);

//	공지사항 등록
	// 마스터테이블 insert
	public int noticeMstInsert(Notice notice);

	// 디테일테이블 insert
	public int noticeDtlInsert(Notice notice);

//	공지사항 수정
	// 마스터테이블 update
	public int noticeMstUpdate(Notice notice);

	// 디테일테이블 update
	public int noticeDtlUpdate(Notice notice);

//	공지사항 삭제
	public int noticeDelete(int notice_code);

}
