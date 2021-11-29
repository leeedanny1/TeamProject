package com.springboot.jcmarket.domain.notice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeRepository {
	
	public Notice getNoticeAll();
	
}
