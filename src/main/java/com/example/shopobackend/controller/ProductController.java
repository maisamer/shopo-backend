package com.example.shopobackend.controller;

import com.example.shopobackend.dto.ProductDto;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.shopobackend.data.Product;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public ResponseModel<List<ProductDto>> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/remove")
    public void removeProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping
    public ResponseModel<ProductDto> getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
}
