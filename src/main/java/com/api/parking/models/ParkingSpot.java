package com.api.parking.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "parking_spot")
@Data
public class ParkingSpot extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true, length = 10)
    private String number;

    @JoinColumn
    @ManyToOne
    private Apartment apartment;
}