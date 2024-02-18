package com.thutohealthcare.medicalsystem.service.impl;

import com.thutohealthcare.medicalsystem.core.exceptions.CustomException;
import com.thutohealthcare.medicalsystem.core.utils.AppUtils;
import com.thutohealthcare.medicalsystem.core.utils.ExportUtils;
import com.thutohealthcare.medicalsystem.core.utils.ModelMapperUtils;
import com.thutohealthcare.medicalsystem.persistence.entity.patient.PatientEntity;
import jakarta.servlet.http.HttpServletResponse;
import com.thutohealthcare.medicalsystem.model.response.PatientResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.thutohealthcare.medicalsystem.persistence.repository.IPatientRepository;
import com.thutohealthcare.medicalsystem.service.IPatientService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepository patientRepository;

    public PatientServiceImpl(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponse> fetchAllPatientUpTo2Years() {
        return ModelMapperUtils.mapAll(patientRepository.findAllByPatient2YearOld(), PatientResponse.class);
    }

    @Override
    public void downloadPatienceProfile(Long id, HttpServletResponse response) {
        PatientEntity patient = patientRepository.findById(id).<CustomException>orElseThrow(() -> {
            throw new CustomException("Patient record cannot be found", HttpStatus.NOT_FOUND);
        });
        ExportUtils.csvWriter(response, List.of(patient), patient.getFirstName().concat(".csv"));
    }

    @Override
    public Boolean deletePatients(String startDate, String endDate) {
        List<PatientEntity> patients = patientRepository.findAllByDateCreatedBetween(AppUtils.parseDate(startDate), AppUtils.parseDate(endDate));
        if (patients.isEmpty()) {
            throw new CustomException("No Record Found", HttpStatus.NOT_FOUND);
        }
        patientRepository.deleteAllInBatch(patients);
        return true;
    }

    @Override
    public Optional<PatientEntity> findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public Optional<PatientEntity> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public PatientEntity save(PatientEntity entity) {
        return patientRepository.save(entity);
    }

    @Override
    public PatientEntity update(PatientEntity entity) {
        final PatientEntity patient = findById(entity.getId()).orElseThrow();
        return save(entity);
    }

    @Override
    public Page<PatientEntity> findAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
