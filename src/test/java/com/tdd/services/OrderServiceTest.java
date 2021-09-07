package com.tdd.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste de compras")
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    private BigDecimal ORDER_PRICE = BigDecimal.valueOf(20);
    private Integer MINOR_AGE = 16;
    private Integer LEGAL_AGE = 18;

    @Test
    @DisplayName("O metodo de disconto não pode dar o disconto pois a pessoa ainda não tem 18 anos")
    void saveShouldNotDiscount() {
        BigDecimal value = orderService.getDiscount(ORDER_PRICE,MINOR_AGE);
        assertEquals(value,ORDER_PRICE);
    }

    @Test
    @DisplayName("O metodo de disconto deve dar o disconto pois a pessoa ainda não tem 18 anos")
    void saveShouldDiscount() {
        BigDecimal value = orderService.getDiscount(ORDER_PRICE,LEGAL_AGE);
        assertNotEquals(value,ORDER_PRICE);
    }

}