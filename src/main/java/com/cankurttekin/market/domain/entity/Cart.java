package com.cankurttekin.market.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_UNIQUE_ITEMS = 10;
    public static final int MAX_TOTAL_ITEM = 30;
    public static final double MAX_TOTAL_AMOUNT = 500000.0;

    private List<Product> products;
    private double totalAmount;  // refactor: bigdecimal
    private int totalQuantity;

    public Cart() {
        this.products = new ArrayList<>();
        //this.totalAmount = BigDecimal.ZERO;
        this.totalAmount = 0;
        this.totalQuantity = 0;
    }

    public void addToCart(Product product) {
        if (product.getPrice() + this.getTotalAmount() <= MAX_TOTAL_AMOUNT
            && this.products.size() + 1 <= MAX_TOTAL_ITEM) {
            this.totalAmount += product.getPrice();
            this.totalQuantity++;
            this.products.add(product);
        }
    }

    public void removeFromCart(int productId) {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
