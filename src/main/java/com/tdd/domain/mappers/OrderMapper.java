package com.tdd.domain.mappers;

import com.tdd.domain.dto.OrderDto;
import com.tdd.domain.dto.OrderResponse;
import com.tdd.domain.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderDto dto);
    OrderDto toDto(Order dto);
    OrderResponse toResponse(Order order);
}
