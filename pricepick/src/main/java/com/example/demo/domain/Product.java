package com.example.demo.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product") // 테이블 이름을 명시적으로 지정
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String brand;

    private int currentPrice;
    private String productUrl;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PriceHistory> priceHistories = new ArrayList<>();
}
