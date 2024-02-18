package com.thutohealthcare.medicalsystem.persistence.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Relationship {

    MOTHER("Mother"),
    FATHER("Father"),
    BROTHER("Brother"),
    SISTER("Sister"),
    GUARDIAN("Guardian");

    private final String displayValue;

}
