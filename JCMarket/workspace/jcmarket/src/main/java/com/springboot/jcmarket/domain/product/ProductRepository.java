package com.springboot.jcmarket.domain.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.product.ProductInsertDto;


@Mapper
public interface ProductRepository {
	
//	상품목록 가져오기
	// 인기상품
	public List<Product> getHotProductListAll();
	// 최근상품
	public List<Product> getNewProductListAll();
	
//	상품 조회수 증가
	public int plusItemCount(int item_code);
	
//	상품 디테일 페이지 가져오기
	public Product getItemDtl(int item_code, int user_id);
	// 이전글
	// 다음글
	
//	상품등록
	// 마스터테이블 insert
	public int productMstInsert(Product product);
	// 디테일테이블 insert
	public int productDtlInsert(Product product);
	
//	상품수정
	// 마스터테이블 update
	public int productMstUpdate(Product product);
	// 디테일테이블 update
	public int productDtlUpdate(Product product);
	
//	상품삭제
	public int productDelete(int item_code);
	
	
	
	
	
	
	
   public int addLike(Product product);
   public int deleteLike(Product product);
   public int upLikeCount(Product product);
   public int downLikeCount(Product product);
   public int getLikeCount(Product product);
   public Product getProduct(Product product);  
   public List<Product> searchProduct(String search_content);
}
