package com.springboot.jcmarket.web.dto.notice;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeInsertDto {
	private String notice_title;
	private String notice_writer;
	private MultipartFile[] notice_file;
	private String notice_content;

}
