package com.thutohealthcare.medicalsystem.persistence.entity.patient;

import com.thutohealthcare.medicalsystem.persistence.entity.common.AbstractEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PatientDiagnosisEntity extends AbstractEntity {

    @Column(name = "date_of_diagnosis")
    private Timestamp dateOfDiagnosis;

    @Column(name = "notes")
    private String notes;
}
