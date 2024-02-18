package com.thutohealthcare.medicalsystem.persistence.repository;

import com.thutohealthcare.medicalsystem.persistence.entity.staff.StaffEntity;
import com.thutohealthcare.medicalsystem.persistence.repository.common.IAbstractRepository;

import java.util.Optional;

public interface IStaffRepository extends IAbstractRepository<StaffEntity> {

    Optional<StaffEntity> findByUuid(String uuid);

    Optional<StaffEntity> findByEmail(String email);

}
