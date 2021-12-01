package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.domain.product.Product;
import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

public interface productService {
    public ProductLikeDto addLike(ProductLikeDto productLikeDto);
    public ProductLikeDto deleteLike(ProductLikeDto productLikeDto);
    public Product getProduct(ProductLikeDto productLikeDto);
}
