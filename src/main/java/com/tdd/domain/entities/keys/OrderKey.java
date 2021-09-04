package com.tdd.domain.entities.keys;

import com.tdd.domain.entities.Item;
import com.tdd.domain.entities.Person;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class OrderKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM",referencedColumnName = "id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON",referencedColumnName = "id")
    private Person person;
//
//    @Column(name = "PERSON_ID")
//    private Long personId;
//
//    @Column(name = "ITEM_ID")
//    private Long itemId;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderKey orderKey = (OrderKey) o;
//        return personId.equals(orderKey.personId) && itemId.equals(orderKey.itemId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(personId, itemId);
//    }
}
