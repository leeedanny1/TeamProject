package com.springboot.jcmarket.web.dto.product;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductInsertDto {
	private String item_title;
	private int item_writer;
	private int like_count;
	private int item_price;
	private int item_stat;
	private int item_change;
	private int item_delivery;
	private String item_content;
	private MultipartFile[] file;
}
