package com.tdd.controllers;

import com.tdd.domain.dto.ItemDto;
import com.tdd.domain.dto.OrderDto;
import com.tdd.domain.entities.Order;
import com.tdd.domain.mappers.ItemMapper;
import com.tdd.domain.mappers.OrderMapper;
import com.tdd.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order/")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;
    private final OrderMapper mapper;
    private final ItemMapper itemMapper;
    @PostMapping("submmit/{personId}")
    public ResponseEntity<OrderDto> save(@RequestBody ItemDto itemDto, @PathVariable(value = "personId") Long personId){
        Order order = service.save(itemMapper.toEntity(itemDto), personId);
        return ResponseEntity.ok(mapper.toDto(order));
    }

}
