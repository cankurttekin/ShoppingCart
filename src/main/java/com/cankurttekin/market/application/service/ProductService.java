package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.model.Product;
import com.cankurttekin.market.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
public interface ProductService {
    List<Product> findAll();
    Product findById(Long productId);
    Product save(Product product);
    void deleteById(Long id);
    void deleteAll();
    //List<Product> findByAvailability(boolean availability);
}
