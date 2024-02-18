package com.thutohealthcare.medicalsystem.persistence.entity.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id = new Random().nextLong(10);

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "date_created", unique = true)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

}
