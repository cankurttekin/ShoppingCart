package com.cankurttekin.market.domain.repository;

import com.cankurttekin.market.domain.entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Optional<Cart> findById(Long id);
    //void save(Cart cart);
}
