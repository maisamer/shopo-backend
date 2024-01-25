package com.example.shopobackend.controller;

import com.example.shopobackend.dto.OrderDto;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    @GetMapping
    public ResponseModel<List<OrderDto>> getAllProducts() {
        return orderService.getUserOrder();
    }
}
