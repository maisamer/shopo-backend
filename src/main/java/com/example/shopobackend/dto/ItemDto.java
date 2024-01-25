package com.example.shopobackend.dto;

import com.example.shopobackend.data.Product;
import lombok.Data;

@Data
public class ItemDto {
    Integer quantity;
    Product product;
}
