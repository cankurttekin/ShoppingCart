package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.entity.Product;
import com.cankurttekin.market.domain.service.ProductService;
import com.cankurttekin.market.infrastructure.repository.ProductRepository;
import com.cankurttekin.market.domain.service.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() ->
                                                        new ProductNotFoundException("Product with provided id not found - " + productId));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
