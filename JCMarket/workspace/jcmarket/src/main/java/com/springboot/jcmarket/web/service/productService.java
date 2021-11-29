package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.web.dto.product.ProductLikeDto;

public interface productService {
    public ProductLikeDto addLike(ProductLikeDto productLikeDto);
    public ProductLikeDto deleteLike(ProductLikeDto productLikeDto);
}
