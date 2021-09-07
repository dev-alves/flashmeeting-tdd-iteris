package com.tdd.helpers;

import com.tdd.domain.entities.Order;

public class OrdersHelper {

    public static Order buildConfigurationValidOrder(){
        return Order.builder()
                .item(ItemHelper.buildConfigurationValidItem())
                .person(PersonHelper.buildConfigurationValidPerson())
                .build();
    }

    public static Order buildConfigurationNotDiscountedOrder(){
        return Order.builder()
                .item(ItemHelper.buildConfigurationValidItem())
                .person(PersonHelper.buildConfigurationInValidPerson())
                .build();
    }
}
