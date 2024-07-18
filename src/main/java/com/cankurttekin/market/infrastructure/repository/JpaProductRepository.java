package com.cankurttekin.market.infrastructure.repository;

import com.cankurttekin.market.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
}
