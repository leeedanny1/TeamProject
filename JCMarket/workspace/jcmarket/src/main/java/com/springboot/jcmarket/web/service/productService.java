package com.springboot.jcmarket.web.service;

import com.springboot.jcmarket.web.dto.product.ProductDto;

public interface productService {
    public int addLike(ProductDto productDto);
}
