package com.api.parking.dtos.Car;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class CarDTO {
    private UUID id;

    @NotBlank
    @NotNull
    @Size(max = 7, min = 7, message = "plate should have 7 characters")
    private String plate;

    @NotBlank
    @NotNull
    private String brand;

    @NotBlank
    @NotNull
    private String model;

    @NotBlank
    @NotNull
    private String color;

    @NotNull
    private UUID person;
}
