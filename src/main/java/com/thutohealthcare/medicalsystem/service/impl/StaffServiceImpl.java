package com.thutohealthcare.medicalsystem.service.impl;

import com.thutohealthcare.medicalsystem.core.exceptions.CustomException;
import com.thutohealthcare.medicalsystem.core.utils.AppUtils;
import com.thutohealthcare.medicalsystem.core.utils.ModelMapperUtils;
import com.thutohealthcare.medicalsystem.persistence.entity.StaffEntity;
import lombok.RequiredArgsConstructor;
import com.thutohealthcare.medicalsystem.model.request.StaffRequest;
import com.thutohealthcare.medicalsystem.model.response.StaffResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.thutohealthcare.medicalsystem.persistence.repository.IStaffRepository;
import com.thutohealthcare.medicalsystem.service.IStaffService;

import java.util.List;

@Service
public class StaffServiceImpl implements IStaffService {

    private final IStaffRepository staffRepository;

    public StaffServiceImpl(IStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public StaffResponse createStaff(StaffRequest request) {
        return ModelMapperUtils.map(staffRepository.save(StaffEntity.builder()
                .name(request.getName())
                .registrationDate(AppUtils.parseDate(request.getRegistrationDate()))
                .build()), StaffResponse.class);
    }

    @Override
    public StaffResponse updateStaff(StaffRequest request, Long id) {
        StaffEntity staff = staffRepository.findById(id).<CustomException>orElseThrow(() -> {
            throw new CustomException("Staff info cannot be found", HttpStatus.NOT_FOUND);
        });
        if (StringUtils.isNotBlank(request.getName())) {
            staff.setName(request.getName());
        }
        if (StringUtils.isNotBlank(request.getRegistrationDate())) {
            staff.setRegistrationDate(AppUtils.parseDate(request.getRegistrationDate()));
        }
        return ModelMapperUtils.map(staffRepository.save(staff), StaffResponse.class);
    }

    @Override
    public List<StaffResponse> fetchAll() {
        return ModelMapperUtils.mapAll(staffRepository.findAll(), StaffResponse.class);
    }
}
