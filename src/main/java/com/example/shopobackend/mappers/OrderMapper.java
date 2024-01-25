package com.example.shopobackend.mappers;

import com.example.shopobackend.data.Item;
import com.example.shopobackend.data.Order;
import com.example.shopobackend.dto.ItemDto;
import com.example.shopobackend.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDto orderToOrderDto(Order order);
    List<OrderDto> orderListToOrderDtoList(List<Order> orderList);
    Order orderDtoToOrder(OrderDto orderDto);

    default ItemDto itemToItemDto(Item item) {
        return Mappers.getMapper(ItemMapper.class).itemToItemDto(item);
    }
}
