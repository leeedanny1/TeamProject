package com.springboot.jcmarket.web.service;

import java.util.List;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.web.beans.ProductBean;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

public interface ProductService {
	
//	전체 상품목록 가져옴
	// 원하는 갯수만큼 담는 리스트를 위한 bean
	public void setProductBean(int pageNumber);
	public ProductBean getProductBean();
	// 페이지 넘버
	public int parseIntPageNumber(int pageNumber);
//	인기상품
	// 모든 공지사항을 가져와서
	public List<Product> getHotProductListAll();
	// 원하는 갯수만큼 노출
	public List<Product> getHotProductList(int pageNumber);
//	최근상품
	// 모든 공지사항을 가져와서
	public List<Product> getNewProductListAll();
	// 원하는 갯수만큼 노출
	public List<Product> getNewProductList(int pageNumber);
	
//	조회수 증가
	public void plusItemCount(int item_code);
	
//	디테일페이지
	public Product getItemDtl(int item_code);
	
//	상품등록
	public int itemInsert(Product product);
	
//	상품수정
	public int itemUpdate(Product product);
	
	
	
	
	
	
    public ProductLikeDto addLike(ProductLikeDto productLikeDto);
    public ProductLikeDto deleteLike(ProductLikeDto productLikeDto);
    public Product getProduct(ProductLikeDto productLikeDto);
    public List<Product> searchProduct(String search_content);
}
