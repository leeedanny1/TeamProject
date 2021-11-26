package com.springboot.jcmarket.web.dto.notice;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.jcmarket.domain.notice.Notice;

import lombok.Data;

@Data
public class NoticeInsertDto {
	private String notice_title;
	private String notice_writer;
	private MultipartFile[] notice_file;
	private String notice_content;
	
	public Notice toEntity() {
		return Notice.builder()
				.notice_title(notice_title)
				.notice_writer(notice_writer)
				.notice_content(notice_content)
				.build();		
	}

}
