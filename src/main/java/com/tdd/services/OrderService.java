package com.tdd.services;

import com.tdd.domain.entities.Item;
import com.tdd.domain.entities.Order;
import com.tdd.domain.entities.Person;
import com.tdd.domain.exceptions.OrderNotFoundException;
import com.tdd.repositories.OrderRepository;
import com.tdd.utils.AgeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PersonService personService;
    private BigDecimal DISCOUNT = BigDecimal.valueOf(0.70);

    public Order findById(Long id){
        return  orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public Order save(Item item, Long personId){
        Person person = personService.findById(personId);
       return orderRepository.save(mountOrder(item, person));
    }

    private Order mountOrder(Item item, Person person) {
        return Order.builder()
                .value(item.getValue())
                .person(person)
                .item(item)
                .build();
    }

    private BigDecimal getDiscount(BigDecimal value, Integer age) {
        AgeUtils ageUtils = new AgeUtils();
        if (ageUtils.isOfLegalAge(age))
            value = (DISCOUNT.multiply(value)).add(value);
        return value;
    }

}
