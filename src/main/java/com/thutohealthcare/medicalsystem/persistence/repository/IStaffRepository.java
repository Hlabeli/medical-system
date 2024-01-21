package com.thutohealthcare.medicalsystem.persistence.repository;

import com.thutohealthcare.medicalsystem.persistence.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStaffRepository extends JpaRepository<StaffEntity, Long> {

    Optional<StaffEntity> findByUuid(String uuid);

}
