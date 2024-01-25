package com.example.shopobackend.mappers;

import com.example.shopobackend.data.Item;
import com.example.shopobackend.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
    ItemDto itemToItemDto(Item item);
    List<ItemDto> itemListToItemDtoList(List<Item> itemList);
    Item itemDtoToItem(ItemDto itemDto);
}
