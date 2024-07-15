package com.cankurttekin.market.domain.entity;

import jakarta.persistence.*;

@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartProductId;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public CartProduct() {}

    public CartProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
