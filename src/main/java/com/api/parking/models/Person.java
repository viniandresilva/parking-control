package com.api.parking.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "person")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Person extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 130)
    private String name;

    @Column(nullable = false, length = 11)
    private String document;

    @OneToMany(mappedBy = "person", targetEntity = Apartment.class)
    private List<Apartment> apartments;

    @OneToMany(mappedBy = "person", targetEntity = Car.class)
    private List<Car> cars;
 }
