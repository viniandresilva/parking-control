package com.api.parking.dtos.ParkingSpot;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class ParkingSpotDTO {
    private UUID id;

    @NotBlank
    @NotNull
    @Size(max = 10, message = "number must be a maximum of 10 characters")
    private String number;

    @NotNull
    private UUID apartment;
}
