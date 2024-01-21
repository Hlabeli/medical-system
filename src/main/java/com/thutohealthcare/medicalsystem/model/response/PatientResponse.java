package com.thutohealthcare.medicalsystem.model.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PatientResponse implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String lastVisitDate;
    private String dateCreated;

}
