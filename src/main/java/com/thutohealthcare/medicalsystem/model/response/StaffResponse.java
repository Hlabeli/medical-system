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
public class StaffResponse extends BaseResponse {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String uuid;
    private String registrationDate;

}
