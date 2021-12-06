package com.springboot.jcmarket.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.domain.product.ProductRepository;
import com.springboot.jcmarket.web.beans.NoticeBean;
import com.springboot.jcmarket.web.beans.ProductBean;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class productServiceImpl implements productService{

    private final ProductRepository productRepository;
    
    private ProductBean productBean;
    private List<Product> productListAll;
    private List<Product> productList;
    
    
//  상품목록 가져오기
    // 빈
    @Override
    public void setProductBean(int pageNumber) {
    	productBean = new ProductBean();
    	
		productBean.setNoticeTotalCount(productListAll.size());
		productBean.setPageNumber(pageNumber);
		productBean.setStartIndex();
		productBean.setEndIndex();
		productBean.setTotalPage();
		productBean.setStartPage();
		productBean.setEndPage();
    }
    
    @Override
    public ProductBean getProductBean() {
    	return productBean;
    }
    
    // 페이지넘버
    @Override
    public int parseIntPageNumber(int pageNumber) {
    	return pageNumber;
    }
    
//  인기상품
    // 모든 상품목록 갸져옴
    @Override
    public List<Product> getHotProductListAll() {
    	return productRepository.getHotProductListAll();
    }
    
    //원하는 갯수만큼 노출
    @Override
    public List<Product> getHotProductList(int pageNumber) {
    	productListAll = getHotProductListAll();
    	productList = new ArrayList<Product>();
    	
    	setProductBean(pageNumber);
    	
    	for (int i = productBean.getStartIndex(); i < productBean.getEndIndex() && i < productBean.getNoticeTotalCount(); i++) {
    		productList.add(productListAll.get(i));
    	}
    	return productList;
    }
//  최근상품
    // 모든 상품목록 갸져옴
    @Override
    public List<Product> getNewProductListAll() {
    	return productRepository.getNewProductListAll();
    }
    
    //원하는 갯수만큼 노출
    @Override
    public List<Product> getNewProductList(int pageNumber) {
    	productListAll = getNewProductListAll();
    	productList = new ArrayList<Product>();
    	
    	setProductBean(pageNumber);
    	
    	for (int i = productBean.getStartIndex(); i < productBean.getEndIndex() && i < productBean.getNoticeTotalCount(); i++) {
    		productList.add(productListAll.get(i));
    	}
    	return productList;
    }
    
    
    
    
    
    
    
    
	
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
	public List<Product> searchProduct(String search_content) {
	      return productRepository.searchProduct(search_content);
	}

}
