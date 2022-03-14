package com.api.parking.dtos.ParkingSpot;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class ListParkingSpotDTO {
    private UUID id;

    private String number;
}
