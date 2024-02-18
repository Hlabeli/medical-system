package com.thutohealthcare.medicalsystem.persistence.entity.patient;

import com.thutohealthcare.medicalsystem.persistence.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPatient {

    private Gender gender = Gender.FEMALE;

    private LocalDate dateOfAdmission;

    private LocalDate dateOfDischarge;

    private Boolean isDeleted = false;
}
