package com.cankurttekin.market.domain.service;

import com.cankurttekin.market.domain.entity.Cart;
import com.cankurttekin.market.domain.service.exception.CartNotFoundException;

public interface CartService {
    // CONSTRAINS
    int MAX_UNIQUE_ITEMS = 10;
    int MAX_TOTAL_ITEM = 30;
    double MAX_TOTAL_AMOUNT = 500000.0;

    // METHODS
    Cart findById(Long id);
    void save(Cart cart);

    void addToCart(Long cartId, Long productId, int quantity);
    void removeFromCart(Long cartId, Long productId, int quantity) throws CartNotFoundException;
}
