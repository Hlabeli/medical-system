package com.thutohealthcare.medicalsystem.service.impl;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import com.thutohealthcare.medicalsystem.model.response.PatientResponse;
import org.springframework.stereotype.Service;
import com.thutohealthcare.medicalsystem.persistence.repository.IPatientRepository;
import com.thutohealthcare.medicalsystem.service.IPatientService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepository patientRepository;

    public PatientServiceImpl(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponse> fetchAllPatientUpTo2Years() {
        return null;
    }

    @Override
    public void downloadPatienceProfile(Long id, HttpServletResponse response) {

    }

    @Override
    public Boolean deletePatients(String startDate, String endDate) {
        return null;
    }
}
