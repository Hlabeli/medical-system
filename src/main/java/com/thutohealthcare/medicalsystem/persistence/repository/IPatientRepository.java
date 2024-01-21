package com.thutohealthcare.medicalsystem.persistence.repository;

import com.thutohealthcare.medicalsystem.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface IPatientRepository extends JpaRepository<PatientEntity, Long> {

    List<PatientEntity> findAllByDateCreatedBetween(Timestamp startDate, Timestamp endDate);

    @Query("select u from Patient u where TIMESTAMPDIFF(YEAR , u.dateCreated, CURDATE()) <= 2")
    List<PatientEntity> findAllByPatient2YearOld();

}
