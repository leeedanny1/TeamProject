package com.springboot.jcmarket.domain.product;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
	
//	mst
	private int item_code;
	private String item_title;
	private int item_writer;
	private LocalDateTime item_date;
	private int item_count;
	
//	dtl
	private int now_sale;
	// 0: 판매중, 1: 예약중, 2: 판매완료
	private int like_count;
	private int item_price;
	private int item_stat;
	// 0: 새상품, 1: S급, 2: A급, 3: B급
	private int item_change;
	// 0:교환가능, 1: 교환불가
	private int item_delivery;
	// 0: 판매자 부담, 1: 구매자 부담, 2: 직거래
	private String item_content;
	private String originFileNames;
	private String tempFileNames;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
//	user_mst
	private String id;
	private String user_nickname;
	
//	like
	private int user_id;
	
	
	
	
	/*
	private int like_flag;
    private int user_id;
    private int item_code;
    private String item_title;
    private String item_writer;
    private int like_count;
    private int item_price;
    private String item_content;
    private String item_start;
    private String item_change;
    private String delivery;
    private String originFileNames;
    private String tempFileNames;
    private String create_date;
    private String update_date;
	*/

}
