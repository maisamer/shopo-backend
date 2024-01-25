package com.example.shopobackend.dto;
import com.example.shopobackend.enums.OrderStatus;
import com.example.shopobackend.enums.PaymentType;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    PaymentType paymentType;
    OrderStatus status;
    Double totalAmount;
    List<ItemDto> items;
}
