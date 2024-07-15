package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.entity.Cart;
import com.cankurttekin.market.domain.entity.CartProduct;
import com.cankurttekin.market.domain.entity.Product;
import com.cankurttekin.market.domain.exception.CartNotFoundException;
import com.cankurttekin.market.domain.repository.CartRepository;
import com.cankurttekin.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements  CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId)
                                                .orElseThrow(() -> new CartNotFoundException("Cart not found"));
    }
    @Override
    public void addToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        CartProduct cartProduct = new CartProduct(productService.findById(productId), quantity);
        cart.getProducts().add(cartProduct);
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
