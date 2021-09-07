package com.tdd.helpers;

import com.tdd.domain.entities.Person;

import java.time.LocalDate;

public class PersonHelper {

    public static Person buildConfigurationValidPerson(){
        return Person.builder()
                .name("teste")
                .id(1L)
                .nascDate(LocalDate.now().minusYears(18))
                .age(18L)
                .build();
    }
    public static Person buildConfigurationInValidPerson(){
        return Person.builder()
                .name("teste")
                .id(1L)
                .nascDate(LocalDate.now().minusYears(17))
                .age(17L)
                .build();
    }
}
