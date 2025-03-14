package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products") // 기본 URL: http://localhost:8080/api/products
public class ProductController {

    private final ProductService productService;

    // 생성자 주입
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1. 상품 등록 API (POST)
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // 2. 모든 상품 조회 API (GET)
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // 3. 상품 ID로 조회 API (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. 상품명으로 조회 API (GET)
    @GetMapping("/search")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        Optional<Product> product = productService.getProductByName(name);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
