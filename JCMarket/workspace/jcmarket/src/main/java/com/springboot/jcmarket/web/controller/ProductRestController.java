package com.springboot.jcmarket.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.web.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
public class ProductRestController {
	
	private final ProductService productService;
	
//	상품등록
	@PostMapping("insert")
	public String itemInsert(Product product) {
		return Integer.toString(productService.itemInsert(product));
	}

}
