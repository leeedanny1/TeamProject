package com.springboot.jcmarket.web.dto.product;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
	private int item_code;
	private String item_title;
	private int item_writer;
	private LocalDateTime item_date;
	private int item_count;
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
	private String tempFileNames;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
