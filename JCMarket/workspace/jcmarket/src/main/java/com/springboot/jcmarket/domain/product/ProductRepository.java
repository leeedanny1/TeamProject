package com.springboot.jcmarket.domain.product;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface ProductRepository {
   public int addLike(Product product);
   public int deleteLike(Product product);
   public int upLikeCount(Product product);
   public int downLikeCount(Product product);
   public int getLikeCount(Product product);
   public Product getProduct(Product product );  
   public Product searchProduct(String search_content);
}
