package com.cankurttekin.market.domain.repository;

import com.cankurttekin.market.domain.entity.Cart;
import com.cankurttekin.market.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,  Long> {
    // REFACTOR: implement custom queries;
    Optional<Cart> findById(Long id);
}
