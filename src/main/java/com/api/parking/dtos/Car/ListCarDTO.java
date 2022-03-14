package com.api.parking.dtos.Car;

import lombok.Data;

import java.util.UUID;

@Data
public class ListCarDTO {
    private UUID id;

    private String plate;

    private String brand;

    private String model;

    private String color;
}
