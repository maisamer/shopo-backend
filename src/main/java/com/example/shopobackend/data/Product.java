package com.example.shopobackend.data;


import com.example.shopobackend.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private String imageUrl;
    private Integer price;
    @ManyToOne
    private Brand brand;
}
