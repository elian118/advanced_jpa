package com.springboot.advanced_jpa.service;

import com.springboot.advanced_jpa.data.dto.ProductDto;
import com.springboot.advanced_jpa.data.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDTO);
    ProductResponseDto changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
