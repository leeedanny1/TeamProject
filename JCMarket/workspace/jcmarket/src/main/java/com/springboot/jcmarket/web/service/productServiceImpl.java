package com.springboot.jcmarket.web.service;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.domain.product.ProductRepository;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class productServiceImpl implements productService{

	
    private final ProductRepository productRepository;
	
	@Override
	public ProductLikeDto addLike(ProductLikeDto productLikeDto) {
		Product product = productLikeDto.toEntity();
		int count_result = 0; 
		int like_result = 0;
		like_result = productRepository.addLike(product);
		
		if(like_result == 1) {
			count_result = productRepository.upLikeCount(product);
			if(count_result == 1) {
				productRepository.getLikeCount(product);
			}
		}
		productLikeDto.setLike_count(count_result);
		productLikeDto.setLike_result(like_result);
		  return productLikeDto;
	}

	@Override
	public ProductLikeDto deleteLike(ProductLikeDto productLikeDto) {
		Product product = productLikeDto.toEntity();
		int count_result = 0; 
		int like_result = 0;
		like_result = productRepository.deleteLike(product);
				
		if(like_result == 1) {
			count_result = productRepository.downLikeCount(product);
			if(count_result == 1) {
				productRepository.getLikeCount(product);
				
			}
		}
		productLikeDto.setLike_count(count_result);
		productLikeDto.setLike_result(like_result);
		  return productLikeDto;
	}

	@Override
	public Product getProduct(ProductLikeDto productLikeDto) {
		  Product product = productLikeDto.toEntity();
		  return productRepository.getProduct(product); 
	}

	@Override
	public Product searchProduct(String search_content) {
	      return productRepository.searchProduct(search_content);
	}

}
