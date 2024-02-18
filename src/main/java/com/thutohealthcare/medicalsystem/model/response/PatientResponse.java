package com.thutohealthcare.medicalsystem.model.response;

import com.thutohealthcare.medicalsystem.model.response.common.BaseResponse;
import com.thutohealthcare.medicalsystem.persistence.entity.enums.Gender;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PatientResponse extends BaseResponse {

    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private Integer age;
    private String email;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String district;
    private String village;
    private String postalCode;
    private String lastVisitDate;

}
