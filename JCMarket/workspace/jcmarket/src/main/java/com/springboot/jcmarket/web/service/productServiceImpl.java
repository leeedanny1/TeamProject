package com.springboot.jcmarket.web.service;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.domain.product.ProductRepository;
import com.springboot.jcmarket.web.dto.product.ProductDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class productServiceImpl implements productService{

	
    private final ProductRepository productRepository; 
	
	@Override
	public int addLike(ProductDto productDto) {
		Product product = productDto.toEntity();
		return productRepository.addLike(product);
	}

}
