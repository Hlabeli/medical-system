package com.thutohealthcare.medicalsystem.service.impl;

import com.thutohealthcare.medicalsystem.core.exceptions.CustomException;
import com.thutohealthcare.medicalsystem.core.utils.AppUtils;
import com.thutohealthcare.medicalsystem.core.utils.ModelMapperUtils;
import com.thutohealthcare.medicalsystem.persistence.entity.staff.StaffEntity;
import com.thutohealthcare.medicalsystem.model.request.StaffRequest;
import com.thutohealthcare.medicalsystem.model.response.StaffResponse;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.thutohealthcare.medicalsystem.persistence.repository.IStaffRepository;
import com.thutohealthcare.medicalsystem.service.IStaffService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {

    private final IStaffRepository staffRepository;

    public StaffServiceImpl(IStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public StaffResponse createStaff(StaffRequest request) {
        return ModelMapperUtils.map(staffRepository.save(StaffEntity.builder()
                .firstName(request.getFirstName())
                .registrationDate(AppUtils.parseDate(request.getRegistrationDate()))
                .build()), StaffResponse.class);
    }

    @Override
    public StaffResponse updateStaff(StaffRequest request, Long id) {
        StaffEntity staff = staffRepository.findById(id).<CustomException>orElseThrow(() -> {
            throw new CustomException("Staff info cannot be found", HttpStatus.NOT_FOUND);
        });
        if (StringUtils.isNotBlank(request.getFirstName())) {
            staff.setFirstName(request.getFirstName());
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

    @Override
    public Optional<StaffEntity> findByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    @Override
    public Optional<StaffEntity> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public StaffEntity save(StaffEntity entity) {
        return staffRepository.save(entity);
    }

    @Override
    public StaffEntity update(StaffEntity entity) {
        final StaffEntity staff = findById(entity.getId()).orElseThrow();
        return save(entity);
    }

    @Override
    public Page<StaffEntity> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        staffRepository.deleteById(id);
    }
}
