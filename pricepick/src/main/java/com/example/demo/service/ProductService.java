package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    // ✅ 생성자 주입 (권장 방식)
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. 상품 저장  / 추가
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 3. 상품 ID로 조회
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // 4. 상품명으로 조회
    public Optional<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }
}
