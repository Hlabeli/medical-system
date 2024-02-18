package com.thutohealthcare.medicalsystem.persistence.entity;

import com.thutohealthcare.medicalsystem.persistence.entity.common.AbstractEntity;
import com.thutohealthcare.medicalsystem.persistence.entity.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PatientEntity extends AbstractEntity {

    @NotEmpty(message = "First name required")
    @Column(name = "first_name", length = 80)
    private String firstName;

    @NotEmpty(message = "Last name required")
    @Column(name = "last_name", length = 80)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "age", length = 3)
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "country")
    private String country;

    @Column(name = "district")
    private String district;

    @Column(name = "village")
    private String village;

    @Column(name = "postal_code")
    private String postCode;

    @Column(name = "last_visit_date")
    private Timestamp lastVisitDate;

}
