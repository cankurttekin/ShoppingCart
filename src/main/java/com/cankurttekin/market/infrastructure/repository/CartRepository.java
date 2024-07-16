package com.cankurttekin.market.infrastructure.repository;

import com.cankurttekin.market.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,  Long> {
}
