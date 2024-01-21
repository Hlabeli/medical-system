package com.thutohealthcare.medicalsystem.model.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StaffResponse implements Serializable {

    private Long id;
    private String name;
    private String uuid;
    private String registrationDate;
    private String dateCreated;

}
