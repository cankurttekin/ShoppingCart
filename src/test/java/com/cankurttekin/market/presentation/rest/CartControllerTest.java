package com.cankurttekin.market.presentation.rest;

import com.cankurttekin.market.domain.entity.Cart;
import com.cankurttekin.market.domain.entity.Product;
import com.cankurttekin.market.domain.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Test
    public void testGetCart() throws Exception {
        Product product = new Product();
        Map<Product, Integer> products = new HashMap<>();
        products.put(product, 1);

        Cart cart = new Cart();
        cart.setProducts(products);

        when(cartService.findById(1L)).thenReturn(cart);

        mockMvc.perform(get("/api/cart/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    public void testAddToCart() throws Exception {
        doNothing().when(cartService).addToCart(1L, 1L, 1);

        mockMvc.perform(post("/api/cart/addToCart/1")
                        .param("productId", "1")
                        .param("quantity", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Product added to cart."));
    }

    @Test
    public void testRemoveFromCart() throws Exception {
        doNothing().when(cartService).removeFromCart(1L, 1L, 1);

        mockMvc.perform(delete("/api/cart/1")
                        .param("productId", "1"))
                .andExpect(status().isOk());
    }
}