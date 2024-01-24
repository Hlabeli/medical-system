package com.thutohealthcare.medicalsystem.resource;

import com.thutohealthcare.medicalsystem.core.annotations.StaffValidation;
import com.thutohealthcare.medicalsystem.core.constants.AppConstant;
import com.thutohealthcare.medicalsystem.model.request.StaffRequest;
import com.thutohealthcare.medicalsystem.model.response.AppResponse;
import com.thutohealthcare.medicalsystem.model.response.StaffResponse;
import com.thutohealthcare.medicalsystem.service.IStaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("staff")
public class StaffController {

    private final IStaffService staffService;

    @PostMapping
    public ResponseEntity<AppResponse<StaffResponse>> createStaff(@Valid @RequestBody StaffRequest request) {
        StaffResponse response = staffService.createStaff(request);
        return ResponseEntity.ok().body(AppResponse.<StaffResponse>builder()
                .data(response)
                .status(HttpStatus.CREATED.value())
                .message(AppConstant.ResponseCode.CREATED)
                .build());
    }

    @PutMapping("{id}")
    @StaffValidation
    public ResponseEntity<AppResponse<StaffResponse>> updateStaff(@Valid @RequestBody StaffRequest request, @PathVariable Long id) {
        StaffResponse response = staffService.updateStaff(request, id);
        return ResponseEntity.ok().body(AppResponse.<StaffResponse>builder()
                .data(response)
                .status(HttpStatus.OK.value())
                .message(AppConstant.ResponseCode.OK)
                .build());
    }

    @GetMapping
    @StaffValidation
    public ResponseEntity<AppResponse<List<StaffResponse>>> fetchAll() {
        List<StaffResponse> response = staffService.fetchAll();
        return ResponseEntity.ok().body(AppResponse.<List<StaffResponse>>builder()
                .data(response)
                .status(HttpStatus.OK.value())
                .message(AppConstant.ResponseCode.OK)
                .build());
    }

}
