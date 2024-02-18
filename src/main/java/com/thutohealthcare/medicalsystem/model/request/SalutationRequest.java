package com.thutohealthcare.medicalsystem.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SalutationRequest {

    @NotBlank(message = "Salutation cannot be empty")
    private String title;
}
