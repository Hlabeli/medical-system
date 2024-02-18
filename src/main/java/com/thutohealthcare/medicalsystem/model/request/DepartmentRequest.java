package com.thutohealthcare.medicalsystem.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DepartmentRequest {

    @NotBlank(message = "Department name cannot be empty")
    private String name;
    private String tel;
    private String email;
}
