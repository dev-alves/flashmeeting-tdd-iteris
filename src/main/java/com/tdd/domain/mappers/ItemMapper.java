package com.tdd.domain.mappers;

import com.tdd.domain.dto.ItemDto;
import com.tdd.domain.entities.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toEntity(ItemDto dto);
    ItemDto toDto(Item dto);
}
