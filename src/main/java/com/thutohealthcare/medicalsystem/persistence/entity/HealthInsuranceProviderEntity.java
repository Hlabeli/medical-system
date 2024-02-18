package com.thutohealthcare.medicalsystem.persistence.entity;

import com.thutohealthcare.medicalsystem.persistence.entity.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HealthInsuranceProviderEntity extends AbstractEntity {

    @NotEmpty(message = "Health insurance provider required")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Email required")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Phone required")
    @Column(name = "phone")
    private String phone;

    @NotEmpty(message = "Address line 1 required")
    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @NotEmpty(message = "Country required")
    @Column(name = "country")
    private String country;

    @NotEmpty(message = "District required")
    @Column(name = "district")
    private String district;

    @Column(name = "postal_code")
    private String postalCode;
}
