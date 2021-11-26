package com.springboot.jcmarket.domain.notice;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Notice {
	
	// notice_mst
	@NotBlank
	private int notice_code;
	@NotBlank
	private String notice_title;
	@NotBlank
	private String notice_writer;
	@NotBlank
	private String notice_date;
	private int notice_count;
	private String create_date;
	private String update_date;
	
	// notice_dtl
	@NotBlank
	private String notice_content;
	private String originFileNames;
	private String tempFileNames;
}
