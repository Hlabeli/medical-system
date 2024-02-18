package com.thutohealthcare.medicalsystem.persistence.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String displayValue;
}
