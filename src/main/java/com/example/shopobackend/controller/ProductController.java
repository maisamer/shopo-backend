package com.example.shopobackend.controller;

import com.example.shopobackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.shopobackend.data.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("add")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("remove")
    public void removeProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
}
