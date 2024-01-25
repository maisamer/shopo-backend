package com.example.shopobackend.service;

import com.example.shopobackend.data.Order;
import com.example.shopobackend.dto.OrderDto;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.mappers.OrderMapper;
import com.example.shopobackend.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    public ResponseModel<List<OrderDto>> getUserOrder(){
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        List<Order> orders = orderRepository.findAllOrdersByUserEmail(user.getName());
        List<OrderDto> orderDtos = orderMapper.orderListToOrderDtoList(orders);
        return ResponseModel.<List<OrderDto>>builder().data(orderDtos).status(HttpStatus.OK.value()).build();
    }
}
