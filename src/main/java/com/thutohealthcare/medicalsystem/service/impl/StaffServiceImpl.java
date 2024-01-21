package com.thutohealthcare.medicalsystem.service.impl;

import lombok.RequiredArgsConstructor;
import com.thutohealthcare.medicalsystem.model.request.StaffRequest;
import com.thutohealthcare.medicalsystem.model.response.StaffResponse;
import org.springframework.stereotype.Service;
import com.thutohealthcare.medicalsystem.persistence.repository.IStaffRepository;
import com.thutohealthcare.medicalsystem.service.IStaffService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements IStaffService {

    private final IStaffRepository staffRepository;

    public StaffServiceImpl(IStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public StaffResponse createStaff(StaffRequest request) {
        return null;
    }

    @Override
    public StaffResponse updateStaff(StaffRequest request, Long id) {
        return null;
    }

    @Override
    public List<StaffResponse> fetchAll() {
        return null;
    }
}
