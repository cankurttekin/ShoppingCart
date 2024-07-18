package com.cankurttekin.market.infrastructure.repository;

import com.cankurttekin.market.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCartRepository extends JpaRepository<Cart,  Long>, com.cankurttekin.market.domain.repository.CartRepository {
}
