package com.springboot.jcmarket.domain.notice;

import java.util.Date;

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
	private Date create_date;
	private Date update_date;

}
