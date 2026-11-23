package com.budiluhur.spring.catalog.api.controller;

import com.budiluhur.spring.catalog.api.dto.ProductCreateRequest;
import com.budiluhur.spring.catalog.api.model.Product;
import com.budiluhur.spring.catalog.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreateRequest request) {
        Product product = productService.createProduct(request);
        return ResponseEntity.status(201).body(product);
    }
}
