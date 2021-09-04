package com.tdd.domain.mappers;

import com.tdd.domain.dto.PersonDto;
import com.tdd.domain.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toEntity(PersonDto dto);

    PersonDto toEntity(Person entity);
}
