package com.thutohealthcare.medicalsystem.model.response;

import com.thutohealthcare.medicalsystem.model.response.common.BaseResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DepartmentResponse extends BaseResponse {

    private String name;
    private String tel;
    private String email;
}
