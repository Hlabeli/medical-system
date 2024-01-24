package com.thutohealthcare.medicalsystem.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StaffEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 80)
    private String name;

    @Column(name = "uuid", unique = true, updatable = false)
    private String uuid;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @PrePersist
    protected void onCreate() {
        this.uuid = UUID.randomUUID().toString();
        this.dateCreated = new Timestamp(System.currentTimeMillis());
    }
}
