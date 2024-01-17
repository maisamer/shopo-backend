package com.example.shopobackend.mappers;

import com.example.shopobackend.data.Product;
import com.example.shopobackend.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    List<ProductDto> productListToProductDtoList(List<Product> productList);
    Product productDtoToProduct(ProductDto productDto);

}
