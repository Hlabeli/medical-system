package com.thutohealthcare.medicalsystem.persistence.repository;


import com.github.javafaker.Faker;
import com.thutohealthcare.medicalsystem.core.utils.AppUtils;
import com.thutohealthcare.medicalsystem.persistence.entity.patient.PatientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.security.SecureRandom;

import static com.thutohealthcare.medicalsystem.core.constants.AppConstant.DateFormatters.AGES;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class PatientRepositoryTest {

    @Autowired
    private IPatientRepository patientRepository;

    private PatientEntity patient;
    private Faker faker;

    @BeforeEach
    public void setup() {
        patient = PatientEntity.builder().build();
        faker = new Faker();
    }

    @Test
    @DisplayName("Create Patient Test")
    void testSaveAndFetchPatient() {
        patient = PatientEntity.builder()
                .id(1L)
                .name(faker.name().name())
                .age(AGES.get(new SecureRandom().nextInt(AGES.size())))
                .lastVisitDate(new Timestamp(faker.date().between(AppUtils.parseDateUtil("2000-01-01"), new Date()).getTime()))
                .dateCreated(new Timestamp(System.currentTimeMillis()))
                .build();

        patient = patientRepository.save(patient);

        PatientEntity fetchPatient = patientRepository.findById(this.patient.getId()).get();

        assertNotNull(this.patient);
        assertNotNull(fetchPatient);
        assertThat(patient).isEqualTo(fetchPatient);
        assertThat(patient.getAge()).isEqualTo(fetchPatient.getAge());
        assertThat(patient.getName()).isEqualTo(fetchPatient.getName());
        assertThat(patient).isExactlyInstanceOf(PatientEntity.class);
        assertThat(fetchPatient).isExactlyInstanceOf(PatientEntity.class);
    }

    @Test
    @DisplayName("Find All Patient by DateCreated Between Test")
    void testFindAllByDateCreatedBetween() {
        patient = PatientEntity.builder()
                .id(1L)
                .name(faker.name().name())
                .age(AGES.get(new SecureRandom().nextInt(AGES.size())))
                .lastVisitDate(new Timestamp(faker.date().between(AppUtils.parseDateUtil("2023-02-01"), new Date()).getTime()))
                .dateCreated(new Timestamp(System.currentTimeMillis()))
                .build();

        patient = patientRepository.save(patient);
        List<PatientEntity> patients = patientRepository.findAllByDateCreatedBetween(AppUtils.parseDate("2023-01-01"), AppUtils.parseDate("2022-04-19"));
        assertNotNull(patients);
        assertThat(patients.size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Find All Patient Up to 2 Years Test")
    void testFindAllByPatient2YearOld() {
        patient = PatientEntity.builder()
                .id(1L)
                .name(faker.name().name())
                .age(AGES.get(new SecureRandom().nextInt(AGES.size())))
                .lastVisitDate(new Timestamp(faker.date().between(AppUtils.parseDateUtil("2023-02-01"), new Date()).getTime()))
                .dateCreated(AppUtils.parseDate("2019-02-01"))
                .build();

        patient = patientRepository.save(patient);
        List<PatientEntity> patients = patientRepository.findAllByPatient2YearOld();
        patients.forEach(patient1 -> assertThat(patient1.getAge()).isIn(AGES));
        assertNotNull(patients);
        assertThat(patients.size()).isGreaterThan(0);
    }

}
