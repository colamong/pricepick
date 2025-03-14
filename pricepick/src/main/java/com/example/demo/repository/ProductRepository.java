package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //상품명으로 조회 (select * from product where name = ?)
    Optional<Product> findByName(String name);
}
