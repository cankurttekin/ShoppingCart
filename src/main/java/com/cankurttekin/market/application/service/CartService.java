package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.entity.Cart;
import com.cankurttekin.market.domain.entity.Product;
import com.cankurttekin.market.domain.exception.CartNotFoundException;

public interface CartService {
    // CONSTRAINS
    int MAX_UNIQUE_ITEMS = 10;
    int MAX_TOTAL_ITEM = 30;
    double MAX_TOTAL_AMOUNT = 500000.0;

    // METHODS
    Cart getCart(Long cartId);
    void addToCart(Long cartId, Long productId, int quantity);

    void removeFromCart(Long cartId, Product product, int quantity) throws CartNotFoundException;

    //List<Product> showProducts();
}
