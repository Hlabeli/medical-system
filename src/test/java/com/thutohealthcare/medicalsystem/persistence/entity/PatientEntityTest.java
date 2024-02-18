package com.thutohealthcare.medicalsystem.persistence.entity;

import com.github.javafaker.Faker;
import com.thutohealthcare.medicalsystem.core.utils.AppUtils;
import com.thutohealthcare.medicalsystem.persistence.entity.patient.PatientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

public class PatientEntityTest {

    private PatientEntity patient;
    private Faker faker;

    @BeforeEach
    public void setup() {
        patient = PatientEntity.builder().build();
        faker = new Faker();
    }

    @Test
    @DisplayName("Patient Entity Test")
    void testPatientEntity() {
        patient = PatientEntity.builder()
                .id(1L)
                .name("Sello Pele")
                .lastVisitDate(new Timestamp(faker.date().between(AppUtils.parseDateUtil("2000-01-01"), new Date()).getTime()))
                .dateCreated(new Timestamp(System.currentTimeMillis()))
                .build();

        assertNotNull(patient);
        assertThat(patient.getName()).isEqualTo("Sello Pele");
    }

}
