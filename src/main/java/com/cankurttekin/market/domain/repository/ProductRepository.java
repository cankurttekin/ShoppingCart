package com.cankurttekin.market.domain.repository;

import com.cankurttekin.market.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long productId);
    //Product save(Product product);
    void deleteById(Long id);
    void deleteAll();
}
