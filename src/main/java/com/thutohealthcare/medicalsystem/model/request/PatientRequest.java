package com.thutohealthcare.medicalsystem.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PatientRequest implements Serializable {

    @NotBlank(message = "Patient name cannot be empty")
    @Size(min = 3, max = 80, message = "Patient name length cannot be less than 3 characters and more than 80 characters")
    private String name;

    @NotNull(message = "Patient age cannot be empty")
    private Integer age;

    @NotNull(message = "Patient last visit date cannot be empty")
    private String lastVisitDate;

}
