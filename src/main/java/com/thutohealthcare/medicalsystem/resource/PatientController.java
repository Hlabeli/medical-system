package com.thutohealthcare.medicalsystem.resource;

import com.thutohealthcare.medicalsystem.core.annotations.StaffValidation;
import com.thutohealthcare.medicalsystem.core.constants.AppConstant;
import com.thutohealthcare.medicalsystem.model.response.AppResponse;
import com.thutohealthcare.medicalsystem.model.response.PatientResponse;
import com.thutohealthcare.medicalsystem.service.IPatientService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("patient")
public class PatientController {

    private final IPatientService patientService;

    @GetMapping
    @StaffValidation
    public ResponseEntity<AppResponse<List<PatientResponse>>> fetchAllPatientUpTo2Years() {
        List<PatientResponse> response = patientService.fetchAllPatientUpTo2Years();
        return ResponseEntity.ok().body(AppResponse.<List<PatientResponse>>builder()
                .data(response)
                .status(HttpStatus.OK.value())
                .message(AppConstant.ResponseCode.OK)
                .build());
    }


    @GetMapping("download/{id}")
    @StaffValidation
    public void downloadPatienceProfile(@PathVariable Long id, HttpServletResponse response) {
        patientService.downloadPatienceProfile(id, response);
    }

    @DeleteMapping
    @StaffValidation
    public ResponseEntity<AppResponse<Boolean>> deletePatients(@RequestParam String startDate, @RequestParam String endDate) {
        Boolean response = patientService.deletePatients(startDate, endDate);
        return ResponseEntity.ok().body(AppResponse.<Boolean>builder()
                .data(response)
                .status(HttpStatus.OK.value())
                .message(AppConstant.ResponseCode.OK)
                .build());
    }

}
