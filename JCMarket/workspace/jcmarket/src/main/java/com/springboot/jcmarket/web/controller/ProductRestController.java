package com.springboot.jcmarket.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	
//	상품수정
	@PutMapping("/update")
	public String itemUpdate(Product product) {
		return Integer.toString(productService.itemUpdate(product));
	}
	
	
	
//	상품삭제
	@DeleteMapping("/delete/{item_code}")
	public String itemDelete(@PathVariable int item_code) {
		return Integer.toString(productService.itemDelete(item_code));
	}

}
