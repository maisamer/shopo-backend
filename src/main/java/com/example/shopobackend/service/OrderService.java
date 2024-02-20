package com.example.shopobackend.service;

import com.example.shopobackend.data.Order;
import com.example.shopobackend.dto.ItemDto;
import com.example.shopobackend.dto.OrderDto;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.enums.OrderStatus;
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

    public ResponseModel<OrderDto> makeOrder(OrderDto orderDto) {
        try {
            orderDto.setStatus(OrderStatus.CREATED);
            orderDto.setTotalAmount(
                    orderDto.getItems().stream().map(ItemDto::calculateTotalCost).reduce(Double::sum).get());
            Order order = orderMapper.orderDtoToOrder(orderDto);
            Order save = orderRepository.save(order);
            return ResponseModel.<OrderDto>builder().status(HttpStatus.CREATED.value()).data(orderDto)
                    .message("Oder created successfully").build();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
