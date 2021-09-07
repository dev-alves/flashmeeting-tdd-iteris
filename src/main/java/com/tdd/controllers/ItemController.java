package com.tdd.controllers;

import com.tdd.domain.dto.ItemDto;
import com.tdd.domain.dto.OrderDto;
import com.tdd.domain.entities.Order;
import com.tdd.domain.mappers.ItemMapper;
import com.tdd.domain.mappers.OrderMapper;
import com.tdd.services.ItemService;
import com.tdd.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("item/")
@RequiredArgsConstructor
public class ItemController {
    
    private final ItemService service;
    private final ItemMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<ItemDto>> listAll(){
        var itens = service.list();
        return ResponseEntity.ok(itens.stream().map(mapper::toDto).collect(Collectors.toList()));
    }

}
