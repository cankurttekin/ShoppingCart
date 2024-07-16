package com.cankurttekin.market.presentation.rest;

import com.cankurttekin.market.application.service.CartService;
import com.cankurttekin.market.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /*
    @GetMapping("{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartService.getCart(cartId));
    }
    */

    @GetMapping("/{cartId}")
    public ResponseEntity<Map<Product, Integer>> getCart(@PathVariable Long cartId) {
        //return cartService.getCart(cartId).getProducts();
        return ResponseEntity.ok(cartService.getCart(cartId).getProducts());
    }

    @PostMapping("/addToCart/{cartId}")
    public ResponseEntity<String> addToCart(@PathVariable Long cartId,
                                              @RequestParam Long productId,
                                              @RequestParam(name = "quantity", defaultValue = "1") int quantity) {
        cartService.addToCart(cartId, productId, quantity);
        return ResponseEntity.ok("Product added to cart.");
    }
}
