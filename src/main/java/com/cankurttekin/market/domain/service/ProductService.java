package com.cankurttekin.market.domain.service;

import com.cankurttekin.market.domain.entity.Product;

import java.util.List;
public interface ProductService {
    List<Product> findAll();
    Product findById(Long productId);
    Product save(Product product);
    void deleteById(Long id);
    void deleteAll();
    //List<Product> findByAvailability(boolean availability);
}
