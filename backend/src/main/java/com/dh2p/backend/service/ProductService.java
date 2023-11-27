package com.dh2p.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.dh2p.backend.repository.ProductRepository;
import com.dh2p.backend.model.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Page<Product> getProductsByCategorySlug(String slug, Pageable pageable) {
        return productRepository.findByCategorySlug(slug, pageable);
    }

    public Product getProductBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    public Page<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Product> findByNameContaining(String keyword, int page, int size) {
        return productRepository.findByNameContaining(keyword, PageRequest.of(page, size));
    }

    public Page<Product> searchProducts(String keyword, Pageable pageable) {
        return productRepository.findByNameContaining(keyword, pageable);
    }
}
