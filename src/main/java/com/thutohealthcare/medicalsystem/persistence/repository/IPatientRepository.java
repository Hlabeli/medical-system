package com.thutohealthcare.medicalsystem.persistence.repository;

import com.thutohealthcare.medicalsystem.persistence.entity.patient.PatientEntity;
import com.thutohealthcare.medicalsystem.persistence.repository.common.IAbstractRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface IPatientRepository extends IAbstractRepository<PatientEntity>, JpaSpecificationExecutor<PatientEntity> {

    List<PatientEntity> findAllByDateCreatedBetween(Timestamp startDate, Timestamp endDate);

    @Query("select u from Patient u where TIMESTAMPDIFF(YEAR , u.dateCreated, CURDATE()) <= 2")
    List<PatientEntity> findAllByPatient2YearOld();

    Optional<PatientEntity> findByEmail(String email);

}
