package com.api.parking.dtos.Person;

import com.api.parking.dtos.Apartment.ListApartmentDTO;
import com.api.parking.dtos.Car.GetCarDTO;
import com.api.parking.dtos.Car.ListCarDTO;
import com.api.parking.models.Apartment;
import com.api.parking.models.Car;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class GetPersonDTO {
    private UUID id;

    private String name;

    private String document;

    private List<ListCarDTO> cars;

    private List<ListApartmentDTO> apartments;
}
