package com.springboot.jcmarket.domain.notice;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.notice.NoticeDto;

@Mapper
public interface NoticeRepository {
	
	public NoticeDto getNotice();
	
}
