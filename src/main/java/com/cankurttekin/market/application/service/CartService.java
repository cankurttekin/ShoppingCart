package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.entity.Product;

public interface CartService {
    // CONSTRAINS
    int MAX_UNIQUE_ITEMS = 10;
    int MAX_TOTAL_ITEM = 30;
    double MAX_TOTAL_AMOUNT = 500000.0;

    // METHODS
    void addToCart(Product product);
    void removeFromCart(int productId);
}
