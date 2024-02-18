package com.thutohealthcare.medicalsystem.model.request;

import com.thutohealthcare.medicalsystem.persistence.entity.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.logging.log4j.message.Message;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PatientRequest implements Serializable {

    @NotBlank(message = "Patient name cannot be empty")
    @Size(min = 3, max = 80, message = "Patient name length cannot be less than 3 characters and more than 80 characters")
    private String firstName;

    @NotBlank(message = "Patient last name cannot be empty")
    @Size(min = 3, max = 80, message = "Patient last name length cannot be less than 3 characters and more than 80 characters")
    private String lastName;

    @NotBlank(message = "Patient date of birth cannot be empty")
    private LocalDate dateOfBirth;

    private Integer age;

    @NotBlank(message = "Gender cannot be empty")
    private Gender gender;

    private String lastVisitDate;

    private String email;

    @NotBlank(message = "Phone cannot be empty")
    private String phone;

    @NotBlank(message = "Address line 1 cannot be empty")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "Gender cannot be empty")
    private String country;

    @NotBlank(message = "District cannot be empty")
    private String district;

    @NotBlank(message = "Village cannot be empty")
    private String village;

    private String postalCode;

}
