package com.example.demo.domain;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class PriceHistory {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int previousPrice;
    private LocalDateTime changedAt;

    // 기본 생성자
    public PriceHistory() {}

    // 생성자
    public PriceHistory(Product product, int previousPrice) {
        this.product = product;
        this.previousPrice = previousPrice;
        this.changedAt = LocalDateTime.now();
    }

    // Getter & Setter (생략 가능)
}

