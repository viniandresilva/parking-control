package com.api.parking.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "apartment")
@Data
public class Apartment extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false, length = 10)
    private String block;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "parking_spot")
    private Person person;

    @OneToMany(mappedBy = "apartment", targetEntity = ParkingSpot.class)
    private List<ParkingSpot> parkingSpots;
}
