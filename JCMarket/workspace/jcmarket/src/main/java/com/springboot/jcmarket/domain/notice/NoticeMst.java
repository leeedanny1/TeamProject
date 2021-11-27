package com.springboot.jcmarket.domain.notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoticeMst {
	
	private int notice_code;
	private String notice_title;
	private String notice_writer;
	private String create_date;
	private String update_date;

}
