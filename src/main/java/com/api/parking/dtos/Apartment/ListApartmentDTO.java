package com.api.parking.dtos.Apartment;

import lombok.Data;

import java.util.UUID;

@Data
public class ListApartmentDTO {
    private UUID id;

    private Integer number;

    private String block;
}
