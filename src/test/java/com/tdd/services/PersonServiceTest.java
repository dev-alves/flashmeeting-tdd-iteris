package com.tdd.services;

import com.tdd.domain.entities.Person;
import com.tdd.domain.exceptions.BirthDateException;
import com.tdd.domain.mappers.PersonMapper;
import com.tdd.helpers.PersonHelper;
import com.tdd.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste de pessoas")
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Spy
    private PersonMapper personMapper;

    private Person validPerson = PersonHelper.buildConfigurationValidPerson();
    private Person invalidPerson = PersonHelper.buildConfigurationInValidPerson();

    @Test
    @DisplayName("Salva uma pessoa, acima  de 18")
    void saveShouldSaveAndReturnPerson() {
        when(personRepository.save(any())).thenReturn(PersonHelper.buildConfigurationValidPerson());
        Person person = personService.save(PersonHelper.buildConfigurationValidPerson());
        assertEquals(person.getNascDate(),validPerson.getNascDate());
        assertEquals(person.getAge(),validPerson.getAge());
        assertEquals(person.getName(),validPerson.getName());
    }

    @Test
    @DisplayName("Não salva uma pessoa, por estar com menos de 18")
    void saveShouldntSavePerson() {
        assertThrows(BirthDateException.class,() -> personService.save(invalidPerson));
    }

}