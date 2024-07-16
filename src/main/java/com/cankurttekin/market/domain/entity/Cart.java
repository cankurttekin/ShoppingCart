package com.cankurttekin.market.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // removed onetomany relation since instead of entities of product list i will hold them with quantites.  so need to map non-entites/embeddable
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    @ElementCollection
    @CollectionTable(name = "cart_product_mapping",
            joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Integer> products = new HashMap<>();

    //@OneToMany(mappedBy = "cart")
    //private List<CartProduct> products;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart") // Bidirectional
   // private List<CartProduct> cartProductList;

    public Cart() {
        //this.products = new ArrayList<>();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
