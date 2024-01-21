package com.thutohealthcare.medicalsystem.service;

import jakarta.servlet.http.HttpServletResponse;
import com.thutohealthcare.medicalsystem.model.response.PatientResponse;

import java.util.List;

public interface IPatientService {

    List<PatientResponse> fetchAllPatientUpTo2Years();

    void downloadPatienceProfile(Long id, HttpServletResponse response);

    Boolean deletePatients(String startDate, String endDate);

}
