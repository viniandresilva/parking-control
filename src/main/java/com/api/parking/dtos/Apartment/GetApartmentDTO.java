package com.api.parking.dtos.Apartment;

import com.api.parking.dtos.ParkingSpot.ListParkingSpotDTO;
import com.api.parking.dtos.Person.GetPersonDTO;
import com.api.parking.dtos.Person.PersonDTO;
import com.api.parking.models.ParkingSpot;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class GetApartmentDTO {
    private UUID id;

    private Integer number;

    private String block;

    private PersonDTO person;

    private List<ListParkingSpotDTO> parkingSpots;
}
