package com.cankurttekin.market.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private List<CartProduct> products;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart") // Bidirectional
    private List<CartProduct> cartProductList;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }
}
