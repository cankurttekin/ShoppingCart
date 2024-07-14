package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.entity.Product;
import com.cankurttekin.market.domain.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements  CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void addToCart(Product product) {
        if (product.getPrice() + Cart.getTotalAmount() <= MAX_TOTAL_AMOUNT
                && this.products.size() + 1 <= MAX_TOTAL_ITEM) {
            this.totalAmount += product.getPrice();
            this.totalQuantity++;
            this.products.add(product);
        }
    }

    @Override
    public void removeFromCart(int productId) {

    }
}
