package com.tdd.domain.entities;

import com.tdd.domain.entities.keys.OrderKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NASC_DATE")
    private LocalDate nascDate;

    @Column(name = "AGE")
    private Long age;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();

    public void addItem(Item item) {
        Order postTag = new Order(this, item);
        orders.add(postTag);
    }

    public void removeItem(Item tag) {
        for (Iterator<Order> iterator = orders.iterator();
             iterator.hasNext(); ) {
            Order order = iterator.next();

            if (order.getPerson().equals(this) &&
                    order.getItem().equals(tag)) {
                iterator.remove();
                order.setPerson(null);
                order.setPerson(null);
            }
        }
    }

}
