package com.tdd.utils;

import com.tdd.domain.exceptions.BirthDateException;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class AgeUtils {

    private final Integer LEGAL_AGE = 16;

    public Integer getAgeByBirthDate(LocalDate birthDate){
        LocalDate now = LocalDate.now();
            return Optional.of(Period.between(birthDate, now).getYears()).orElseThrow(BirthDateException::new);
    }

    public Boolean isOfLegalAge(Integer age){
        return BooleanUtils.isTrue(LEGAL_AGE <= age);
    }

}
