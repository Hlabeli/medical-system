package com.thutohealthcare.medicalsystem.service;

import com.thutohealthcare.medicalsystem.model.request.StaffRequest;
import com.thutohealthcare.medicalsystem.model.response.StaffResponse;

import java.util.List;

public interface IStaffService {

    StaffResponse createStaff(StaffRequest request);

    StaffResponse updateStaff(StaffRequest request, Long id);

    List<StaffResponse> fetchAll();

}
