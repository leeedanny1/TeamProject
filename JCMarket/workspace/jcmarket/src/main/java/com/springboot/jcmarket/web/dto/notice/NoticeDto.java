package com.springboot.jcmarket.web.dto.notice;

import lombok.Data;

@Data
public class NoticeDto {
	
	private int notice_code;
	private String notice_title;
	private String notice_writer;
	private String notice_date;
	private int notice_count;

}
