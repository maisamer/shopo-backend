package com.example.shopobackend.service;

import com.example.shopobackend.data.Product;
import com.example.shopobackend.dto.ProductDto;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.exceptions.ItemNotFoundException;
import com.example.shopobackend.mappers.ProductMapper;
import com.example.shopobackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public ResponseModel<List<ProductDto>> getAllProducts() {
        ResponseModel.ResponseModelBuilder<List<ProductDto>> builder = ResponseModel.builder();
        try {
            List<Product> allProducts = productRepository.findAll();
            List<ProductDto> productDtos = productMapper.productListToProductDtoList(allProducts);
            builder.status(HttpStatus.OK.value()).message("PRODUCTS FETCH").data(productDtos);
        }catch (Exception e){
            builder.status(HttpStatus.OK.value()).message(e.getMessage()).data(new ArrayList<>());
        }
        return builder.build();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ResponseModel<ProductDto> getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            ProductDto productDto = productMapper.productToProductDto(productOptional.get());
            return ResponseModel.<ProductDto>builder().status(HttpStatus.FOUND.value())
                    .data(productDto).build();
        }
        throw new ItemNotFoundException("Product not found");
    }
}
