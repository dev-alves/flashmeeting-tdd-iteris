package com.tdd.helpers;

import com.tdd.domain.entities.Item;

import java.math.BigDecimal;

public class ItemHelper {


    public static Item buildConfigurationValidItem(){
        return Item.builder()
                .name("teste")
                .id(1L)
                .value(BigDecimal.valueOf(200))
                .build();
    }
}
