package com.thutohealthcare.medicalsystem.model.request;

import com.thutohealthcare.medicalsystem.persistence.entity.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StaffRequest implements Serializable {

    @NotBlank(message = "Staff first name cannot be empty")
    @Size(min = 3, max = 80, message = "Staff first name length cannot be less than 3 characters and more than 80 characters")
    private String firstName;

    @NotBlank(message = "Staff last name cannot be empty")
    @Size(min = 3, max = 80, message = "Staff last name length cannot be less than 3 characters and more than 80 characters")
    private String lastName;

    @NotBlank(message = "Gender cannot be empty")
    private Gender gender;

    @NotBlank(message = "Date of Birth cannot be empty")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Phone cannot be empty")
    private LocalDate phone;

    @NotBlank(message = "Staff registration date cannot be empty")
    private String registrationDate;

}
