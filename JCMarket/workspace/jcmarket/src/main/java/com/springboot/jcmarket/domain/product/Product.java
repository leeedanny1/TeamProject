package com.springboot.jcmarket.domain.product;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Product {
	
	private int id;
	private int user_id;
    private int item_code;
    private String item_title;
    private String item_writer;
    private int item_price;
    private String item_content;
    private String item_start;
    private String item_change;
    private String delivery;
    private String originFileNames;
    private String tempFileNames;
    private String create_date;
    private String update_date;

}
