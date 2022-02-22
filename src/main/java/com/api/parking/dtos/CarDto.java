package com.api.parking.dtos;

import com.api.parking.models.Person;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarDto {

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 7, min = 7, message = "plate should have 7 characters")
    private String plate;

    @NotBlank
    @NotEmpty
    @NotNull
    private String brand;

    @NotBlank
    @NotEmpty
    @NotNull
    private String model;

    @NotBlank
    @NotEmpty
    @NotNull
    private String color;

    @NotBlank
    @NotEmpty
    @NotNull
    private Person person;
}
