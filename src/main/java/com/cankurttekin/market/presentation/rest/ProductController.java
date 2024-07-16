package com.cankurttekin.market.presentation.rest;

import com.cankurttekin.market.domain.service.ProductService;
import com.cankurttekin.market.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        product.setId(0L);
        return productService.save(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        Product tempProduct = productService.findById(productId);

        if (tempProduct == null) {
            //throw new ProductNotFoundException("Product id not found - " + product.getId());
        }
        product.setId(productId);
        //Product dbProduct = productService.save(theProduct);
        //return dbProduct;
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        Product tempProduct = productService.findById(productId); // refactor
        productService.deleteById(productId);
        return "Deleted product - " + productId.toString(); // refactor
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllProducts() {
        productService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //
    }

}
