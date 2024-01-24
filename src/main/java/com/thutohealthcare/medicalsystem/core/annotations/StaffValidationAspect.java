package com.thutohealthcare.medicalsystem.core.annotations;

import com.thutohealthcare.medicalsystem.core.constants.AppConstant;
import com.thutohealthcare.medicalsystem.core.exceptions.CustomException;
import com.thutohealthcare.medicalsystem.persistence.repository.IStaffRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.thutohealthcare.medicalsystem.core.constants.AppConstant.Headers.AUTHORIZATION;
import static com.thutohealthcare.medicalsystem.core.constants.AppConstant.ResponseCode.UNKNOWN_STAFF;

@Service
@Aspect
@RequiredArgsConstructor
@Slf4j
public class StaffValidationAspect {

    private final IStaffRepository staffRepository;
    private final HttpServletRequest httpServletRequest;

    @Pointcut("@annotation(com.thutohealthcare.medicalsystem.core.annotations.StaffValidation)")
    public void postAction() {
    }

    @After("postAction()")
    public void validateStaff() {
        String staffUUID = httpServletRequest.getHeader(AUTHORIZATION);
        if (Objects.isNull(staffUUID)) {
            throw new CustomException(UNKNOWN_STAFF, HttpStatus.UNAUTHORIZED);
        }
        staffRepository.findByUuid(staffUUID).<CustomException>orElseThrow(() -> {
            throw new CustomException(AppConstant.ResponseCode.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
        });
    }

}
