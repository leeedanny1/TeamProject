package com.springboot.jcmarket.web.dto.notice;

import lombok.Data;

@Data
public class NoticeDto {
	
	private int notice_code;
	private String notice_title;
	private String notice_writer;
	private String notice_date;
	private int notice_count;
	private String notice_content;
	private String originFileNames;
	private String tempFileNames;
	
	private int nextNotice_code; // 다음 글 코드
	private String nextNotice_title;
	private int preNotice_code; // 이전 글 코드
	private String preNotice_title;
	
	
	

}
