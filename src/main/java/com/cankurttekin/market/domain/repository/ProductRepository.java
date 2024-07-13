package com.cankurttekin.market.domain.repository;

import com.cankurttekin.market.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // add custom queries if needed
}
