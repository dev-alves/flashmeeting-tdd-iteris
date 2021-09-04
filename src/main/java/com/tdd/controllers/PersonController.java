package com.tdd.controllers;

import com.tdd.domain.dto.PersonDto;
import com.tdd.domain.mappers.PersonMapper;
import com.tdd.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "person/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    @PostMapping(value = "save/")
    public ResponseEntity<Void> savePerson(@RequestBody PersonDto personDto){
        personService.save(personMapper.toEntity(personDto));
        return ResponseEntity.ok().build();
    }
}
