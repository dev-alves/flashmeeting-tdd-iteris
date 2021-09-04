package com.tdd.services;

import com.tdd.domain.entities.Person;
import com.tdd.domain.exceptions.BirthDateException;
import com.tdd.domain.exceptions.PersonNotFoundException;
import com.tdd.repositories.PersonRepository;
import com.tdd.utils.AgeUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    public Person save(Person entity){
        AgeUtils ageUtils = new AgeUtils();
        entity.setAge(Integer.toUnsignedLong(ageUtils.getAgeByBirthDate(entity.getNascDate())));
        if (BooleanUtils.isFalse(ageUtils.isOfLegalAge(entity.getAge().intValue())))
            throw new BirthDateException("Pessoa não tem idade para se inscrever");
        return repository.save(entity);
    }

    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(PersonNotFoundException::new);
    }
}
