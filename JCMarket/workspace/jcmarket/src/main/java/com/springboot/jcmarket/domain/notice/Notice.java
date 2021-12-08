package com.springboot.jcmarket.domain.notice;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Notice {
	//notice_mst
	private int notice_code;
	private String notice_title;
	private String notice_writer;
	private LocalDateTime notice_date;
	private int notice_count;
	//notice_dtl
	private String notice_content;
	private String originFileNames;
	private String tempFileNames;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	// user_mst
	private String id;
	private String user_nickname;
}
