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
public class NoticeDtl {
	
	private int notice_code;
	private String notice_content;
	private String originFileNames;
	private String tempFileNames;
	private Date create_date;
	private Date update_date;
	

}
