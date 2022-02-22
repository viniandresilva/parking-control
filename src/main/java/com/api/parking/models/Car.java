package com.api.parking.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "car")
@Data
public class Car extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true, length = 7)
    private String plate;

    @Column(nullable = false, length = 70)
    private String brand;

    @Column(nullable = false, length = 70)
    private String model;

    @Column(nullable = false, length = 70)
    private String color;

    @ManyToOne(targetEntity = Person.class)
    private Person person;
}
