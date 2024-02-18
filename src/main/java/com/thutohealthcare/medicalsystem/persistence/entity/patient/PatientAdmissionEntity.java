package com.thutohealthcare.medicalsystem.persistence.entity.patient;

import com.thutohealthcare.medicalsystem.persistence.entity.common.AbstractEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PatientAdmissionEntity extends AbstractEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_admission")
    private LocalDate dateOfAdmission;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_admission")
    private LocalDate dateOfDischarge;

    @Column(name = "ward_number")
    private String wardNumber;

    @Column(name = "bed_number")
    private String bedNumber;

    @Column(name = "notes")
    private String notes;

}
