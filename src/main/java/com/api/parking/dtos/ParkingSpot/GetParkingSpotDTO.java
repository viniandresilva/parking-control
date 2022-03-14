package com.api.parking.dtos.ParkingSpot;

import com.api.parking.dtos.Apartment.GetApartmentDTO;
import com.api.parking.dtos.Apartment.ListApartmentDTO;
import com.api.parking.models.Apartment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class GetParkingSpotDTO {
    private UUID id;

    private String number;

    private ListApartmentDTO apartment;
}
