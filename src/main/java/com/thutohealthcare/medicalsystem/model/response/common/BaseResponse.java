package com.thutohealthcare.medicalsystem.model.response.common;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public abstract class BaseResponse implements Serializable {

    private Long id;
    private LocalDateTime dateCreated;
    private Boolean isDeleted;

}
