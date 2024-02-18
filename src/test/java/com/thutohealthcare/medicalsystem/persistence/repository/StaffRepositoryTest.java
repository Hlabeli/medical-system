package com.thutohealthcare.medicalsystem.persistence.repository;

import com.github.javafaker.Faker;
import com.thutohealthcare.medicalsystem.core.utils.AppUtils;
import com.thutohealthcare.medicalsystem.persistence.entity.staff.StaffEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class StaffRepositoryTest {

    private StaffEntity staff;
    private Faker faker;

    @BeforeEach
    public void setup() {
        staff = StaffEntity.builder().build();
        faker = new Faker();
    }

    @Test
    @DisplayName("Staff Entity Test")
    void testStaffEntity() {
        staff = StaffEntity.builder()
                .id(1L)
                .name("Sello Pele")
                .uuid(UUID.randomUUID().toString())
                .registrationDate(new Timestamp(faker.date().between(AppUtils.parseDateUtil("2000-01-01"), new Date()).getTime()))
                .dateCreated(new Timestamp(System.currentTimeMillis()))
                .build();

        assertNotNull(staff);
        assertThat(staff.getName()).isEqualTo("Sello Pele");
    }

}
