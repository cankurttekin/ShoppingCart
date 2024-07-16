package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.entity.Cart;
import com.cankurttekin.market.domain.entity.Product;
import com.cankurttekin.market.domain.exception.CartNotFoundException;
import com.cankurttekin.market.infrastructure.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements  CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public Cart getCart(Long cartId) {
        cartRepository.findById(cartId).

                                                //.orElseThrow(() -> new CartNotFoundException("Cart not found"));
    }

    @Override
    public Cart findById(Long id) {
        return null;
    }

    @Override
    public void save(Cart cart) {

    }

    @Override
    public void addToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        Product product = productService.findById(productId);
        //CartProduct cartProduct = new CartProduct(productService.findById(productId), quantity);
        //cart.getProducts().add(product);
        cart.getProducts().put(product, quantity);
        cartRepository.save(cart);

    }

    @Override
    public void removeFromCart(Long cartId, Product product, int quantity) throws CartNotFoundException {
        /*
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        if (cart.getProducts().contains(product.getId())) {
            //int newQuantity = cart.getProducts().get(product.()) - quantity;
            if (newQuantity <= 0) {
                cart.getProducts().remove(product.getId());
            } else {
                cart.getProducts().put(product, newQuantity);
            }
            cartRepository.save(cart);
        }
         */
    }
}
