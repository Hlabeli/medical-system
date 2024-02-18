package com.thutohealthcare.medicalsystem.persistence.entity;

import com.thutohealthcare.medicalsystem.persistence.entity.common.AbstractEntity;
import com.thutohealthcare.medicalsystem.persistence.entity.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StaffEntity extends AbstractEntity {

    @NotEmpty(message = "First name is required")
    @Column(name = "first_name", length = 80)
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Column(name = "last_name", length = 80)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "uuid", unique = true, updatable = false)
    private String uuid;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

    @PrePersist
    protected void onCreate() {
        this.uuid = UUID.randomUUID().toString();
    }
}
