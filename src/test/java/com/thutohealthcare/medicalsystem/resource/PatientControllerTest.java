package com.thutohealthcare.medicalsystem.resource;

import com.thutohealthcare.medicalsystem.service.IPatientService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.thutohealthcare.medicalsystem.core.constants.AppConstant.ResponseCode.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPatientService patientService;

    @BeforeEach
    public void setup() {

    }

    @SneakyThrows
    @Test
    @DisplayName("Fetch All Patient Up to 2 Years Endpoint - Test")
    void testFetchAllPatientUpTo2YearsEndpoint() {

        mockMvc.perform(get("/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(OK))
                .andExpect(jsonPath("$.status").value(200));
    }

    @SneakyThrows
    @Test
    @DisplayName("Delete Patients With Date Range Endpoint - Test")
    void testDeletePatientsEndpoint() {

        mockMvc.perform(delete("/patient")
                        .queryParam("startDate", "2020-01-01")
                        .queryParam("endDate", "2022-01-01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(OK))
                .andExpect(jsonPath("$.status").value(200));
    }

}
