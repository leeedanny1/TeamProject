package com.springboot.jcmarket.domain.notice;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.notice.NoticeDto;

@Mapper
public interface NoticeRepository {
	
//	게시글 가져오기
	public NoticeDto getNotice(int notice_code);
//	코드번호 가져오기
	public int getNoticeMaxCode();
//	조회수 +
	public int plusNoticeCount(int notice_code);
//	글쓰기
	public int noticeMstInsert(NoticeDto noticeDto);
	public int noticeDtlInsert(NoticeDto noticeDto);
}
