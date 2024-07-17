package com.cankurttekin.market.application.service;

import com.cankurttekin.market.domain.entity.Product;
import com.cankurttekin.market.domain.service.exception.ProductNotFoundException;
import com.cankurttekin.market.infrastructure.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> productList = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Product product = new Product();
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.findById(1L);
        assertEquals(product, result);
    }

    @Test
    public void testFindById_NotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> {
            productService.findById(1L);
        });
    }

    @Test
    public void testSave() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);
        assertEquals(product, result);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteById(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteAll() {
        doNothing().when(productRepository).deleteAll();

        productService.deleteAll();
        verify(productRepository, times(1)).deleteAll();
    }
}