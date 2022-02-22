package com.api.parking.models;


import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    @LastModifiedDate
    @Column(nullable = false)
    private ZonedDateTime updatedAt = ZonedDateTime.now();
}
