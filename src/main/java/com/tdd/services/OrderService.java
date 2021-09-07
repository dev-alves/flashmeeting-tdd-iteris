package com.tdd.services;

import com.tdd.domain.dto.OrderDto;
import com.tdd.domain.entities.Item;
import com.tdd.domain.entities.Order;
import com.tdd.domain.entities.Person;
import com.tdd.domain.exceptions.OrderNotFoundException;
import com.tdd.repositories.OrderRepository;
import com.tdd.utils.AgeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PersonService personService;
    private final ItemService itemService;
    private BigDecimal DISCOUNT = BigDecimal.valueOf(0.70);

    public Order findById(Long id){
        return  orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public Order save(Item item, Person person){
       return orderRepository.save(mountOrder(item, person));
    }

    private Order mountOrder(Item item, Person person) {
        return Order.builder()
                .value(getDiscount(item.getValue(),person.getAge().intValue()))
                .person(person)
                .item(item)
                .build();
    }

    public BigDecimal getDiscount(BigDecimal value, Integer age) {
        AgeUtils ageUtils = new AgeUtils();
        var total = value;
        if (ageUtils.isOfLegalAge(age)) {
            var porc = (DISCOUNT.multiply(value));
            total = value.subtract(porc);
        }
        return total;
    }

    public List<Order> listByPersonId(Long personId) {
        return orderRepository.findByPersonId(personId);
    }
}
