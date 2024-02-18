package com.thutohealthcare.medicalsystem.persistence.entity;

import com.thutohealthcare.medicalsystem.persistence.entity.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DepartmentEntity extends AbstractEntity {

    @NotEmpty(message = "Department name required")
    @Column(name = "name")
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email")
    private String email;

}
