package com.example.shopobackend.dto;

import com.example.shopobackend.data.Brand;
import com.example.shopobackend.enums.ProductCategory;
import lombok.Data;

@Data
public class ProductDto {
    private Integer price;
    private String name;
    private Brand brand;
    private String imageUrl;
    private String description;
    private ProductCategory category;
}
