package com.api.parking.dtos.Person;

import lombok.Data;

import java.util.UUID;

@Data
public class ListPersonDTO {
    private UUID id;

    private String name;

    private String document;
}
