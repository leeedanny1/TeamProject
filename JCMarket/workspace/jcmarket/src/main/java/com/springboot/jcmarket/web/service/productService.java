package com.springboot.jcmarket.web.service;

import java.util.List;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

public interface productService {
    public ProductLikeDto addLike(ProductLikeDto productLikeDto);
    public ProductLikeDto deleteLike(ProductLikeDto productLikeDto);
    public Product getProduct(ProductLikeDto productLikeDto);
    public List<Product> searchProduct(String search_content);
}
