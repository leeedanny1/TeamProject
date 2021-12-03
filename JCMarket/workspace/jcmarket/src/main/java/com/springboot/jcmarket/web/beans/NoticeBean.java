package com.springboot.jcmarket.web.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeBean {
	
	private int noticeTotalCount;
	private int pageNumber;
	private int startIndex;
	private int endIndex;
	private int totalPage;
	private int startPage;
	private int endPage;

}
