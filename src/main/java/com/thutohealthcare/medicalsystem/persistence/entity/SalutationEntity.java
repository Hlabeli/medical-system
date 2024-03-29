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
public class SalutationEntity extends AbstractEntity {

    @NotEmpty(message = "Title required")
    @Column(name = "title")
    private String title;
}
