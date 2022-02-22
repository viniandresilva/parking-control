package com.api.parking.dtos;

import com.api.parking.models.Apartment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ParkingSpotDto {

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 10, message = "number must be a maximum of 10 characters")
    private String number;

    @NotBlank
    @NotEmpty
    @NotNull
    private Apartment apartment;

}
