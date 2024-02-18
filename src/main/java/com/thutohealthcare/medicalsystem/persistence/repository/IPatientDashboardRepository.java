package com.thutohealthcare.medicalsystem.persistence.repository;

import com.thutohealthcare.medicalsystem.persistence.entity.patient.PatientEntity;
import com.thutohealthcare.medicalsystem.persistence.repository.common.IAbstractRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPatientDashboardRepository extends IAbstractRepository<PatientEntity>, JpaSpecificationExecutor<PatientEntity> {
}
