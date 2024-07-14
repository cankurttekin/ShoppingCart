package com.cankurttekin.market.domain.repository;

import com.cankurttekin.market.domain.entity.Cart;
import com.cankurttekin.market.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, List<Product>> {
    // REFACTOR: implement custom queries;
}
