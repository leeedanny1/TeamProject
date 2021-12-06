package com.springboot.jcmarket.web.dto.notice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticePreNextDto {
	private int pre_code;
	private String pre_title;
	private int next_code;
	private String next_title;
}
