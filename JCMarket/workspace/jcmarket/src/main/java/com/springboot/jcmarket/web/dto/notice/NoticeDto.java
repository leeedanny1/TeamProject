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
	

}
