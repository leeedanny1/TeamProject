package com.springboot.jcmarket.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
public class ProductRestController {
	
//	상품등록
	@PostMapping("insert")
	public String itemInsert() {
		return null;
	}

}
