package com.springboot.jcmarket.web.dto.notice;

import java.time.LocalDateTime;

import com.springboot.jcmarket.domain.notice.Notice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeDto {
	
	private int notice_code;
	private String notice_title;
	private String notice_writer;
	private LocalDateTime notice_date;
	private int notice_count;
	private String notice_content;
	private String originFileNames;
	private String tempFileNames;
	
	public Notice toEntity() {
		return Notice.builder()
				.notice_code(notice_code)
				.notice_title(notice_title)
				.notice_writer(notice_writer)
				.notice_date(notice_date)
				.notice_count(notice_count)
				.notice_content(notice_content)
				.originFileNames(originFileNames)
				.tempFileNames(tempFileNames)
				.build();
		
	}

}
