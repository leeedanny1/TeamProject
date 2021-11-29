package com.springboot.jcmarket.domain.product;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
   public int addLike(Product product);
}
