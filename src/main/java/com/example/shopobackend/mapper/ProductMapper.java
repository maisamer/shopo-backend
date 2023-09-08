package com.example.shopobackend.mapper;

import com.example.shopobackend.data.Product;
import com.example.shopobackend.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProductDTO(ProductDTO productDTO);
    ProductDTO toProduct(Product productDTO);
}
