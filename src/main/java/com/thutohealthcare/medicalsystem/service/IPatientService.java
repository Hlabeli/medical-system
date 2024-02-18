package com.thutohealthcare.medicalsystem.service;

import com.thutohealthcare.medicalsystem.persistence.entity.patient.PatientEntity;
import jakarta.servlet.http.HttpServletResponse;
import com.thutohealthcare.medicalsystem.model.response.PatientResponse;

import java.util.List;
import java.util.Optional;

public interface IPatientService extends IAbstractService<PatientEntity> {

    List<PatientResponse> fetchAllPatientUpTo2Years();

    void downloadPatienceProfile(Long id, HttpServletResponse response);

    Boolean deletePatients(String startDate, String endDate);

    Optional<PatientEntity> findByEmail(String email);

}
