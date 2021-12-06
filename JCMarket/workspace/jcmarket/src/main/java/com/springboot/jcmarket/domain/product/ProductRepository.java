package com.springboot.jcmarket.domain.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductRepository {
	
//	상품목록 가져오기
	// 인기상품
	public List<Product> getHotProductListAll();
	// 최근상품
	public List<Product> getNewProductListAll();
	
	
	
	
	
   public int addLike(Product product);
   public int deleteLike(Product product);
   public int upLikeCount(Product product);
   public int downLikeCount(Product product);
   public int getLikeCount(Product product);
   public Product getProduct(Product product);  
   public List<Product> searchProduct(String search_content);
}
