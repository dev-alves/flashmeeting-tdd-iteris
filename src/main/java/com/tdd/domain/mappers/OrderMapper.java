package com.tdd.domain.mappers;

import com.tdd.domain.dto.ItemDto;
import com.tdd.domain.dto.OrderDto;
import com.tdd.domain.entities.Item;
import com.tdd.domain.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderDto dto);
    OrderDto toDto(Order dto);
}
