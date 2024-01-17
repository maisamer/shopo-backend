package com.example.shopobackend.service;

import com.example.shopobackend.data.Product;
import com.example.shopobackend.dto.ProductDto;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.mappers.ProductMapper;
import com.example.shopobackend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
