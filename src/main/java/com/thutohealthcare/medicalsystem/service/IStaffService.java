package com.thutohealthcare.medicalsystem.service;

import com.thutohealthcare.medicalsystem.model.request.StaffRequest;
import com.thutohealthcare.medicalsystem.model.response.StaffResponse;
import com.thutohealthcare.medicalsystem.persistence.entity.staff.StaffEntity;

import java.util.List;
import java.util.Optional;

public interface IStaffService extends IAbstractService<StaffEntity> {

    StaffResponse createStaff(StaffRequest request);

    StaffResponse updateStaff(StaffRequest request, Long id);

    List<StaffResponse> fetchAll();

    Optional<StaffEntity> findByEmail(String email);

}
