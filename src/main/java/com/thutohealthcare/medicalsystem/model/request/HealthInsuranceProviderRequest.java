package com.thutohealthcare.medicalsystem.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HealthInsuranceProviderRequest {

    @NotBlank(message = "Health insurance provider name cannot be empty")
    private String name;
    private String phone;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String district;
    private String postalCode;
}
