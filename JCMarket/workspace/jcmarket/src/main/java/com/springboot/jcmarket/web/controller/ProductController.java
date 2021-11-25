package com.springboot.jcmarket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/items")
@Controller
public class ProductController {

/*
 * 페이지 연결
 */
	
//	hot-items 연결
	@GetMapping("/hot")
	public String hotProduct() {
		return "product/hot_product";
	}
	
//	new-items 연결
	@GetMapping("/new")
	public String newProduct() {
		return "product/new_product";
	}
	
//	물건 판매 연결
	@GetMapping("/sale")
	public String sale() {
		return "product/product_insert";
	}
}
