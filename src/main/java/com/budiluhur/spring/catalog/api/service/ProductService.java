package com.budiluhur.spring.catalog.api.service;

import com.budiluhur.spring.catalog.api.dto.ProductCreateRequest;
import com.budiluhur.spring.catalog.api.exception.ResourceNotFoundException;
import com.budiluhur.spring.catalog.api.model.Product;
import com.budiluhur.spring.catalog.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        // Menggunakan Java 8 Optional + Lambda () ->
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produk dengan ID '" + id + "' tidak ditemukan!"));
    }

    public Product createProduct(ProductCreateRequest request) {
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }
}
