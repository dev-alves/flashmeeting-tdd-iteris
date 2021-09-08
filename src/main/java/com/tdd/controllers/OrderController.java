package com.tdd.controllers;

import com.tdd.domain.dto.ItemDto;
import com.tdd.domain.dto.OrderDto;
import com.tdd.domain.dto.OrderResponse;
import com.tdd.domain.entities.Order;
import com.tdd.domain.mappers.ItemMapper;
import com.tdd.domain.mappers.OrderMapper;
import com.tdd.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order/")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;
    private final OrderMapper mapper;

    @PostMapping("submmit")
    public ResponseEntity<OrderResponse> save(@RequestBody OrderDto orderDto){
        Order order = service.save(orderDto);
        return ResponseEntity.ok(mapper.toResponse(order));
    }
    @GetMapping("list/{personId}")
    public ResponseEntity<List<OrderResponse>> list(@PathVariable(value = "personId") Long personId){
        List<Order> orders = service.listByPersonId(personId);
        return ResponseEntity.ok(orders.stream().map(mapper::toResponse).collect(Collectors.toList()));
    }

}
