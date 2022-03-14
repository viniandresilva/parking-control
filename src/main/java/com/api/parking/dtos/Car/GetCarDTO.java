package com.api.parking.dtos.Car;

import com.api.parking.dtos.Person.GetPersonDTO;
import com.api.parking.dtos.Person.PersonDTO;
import com.api.parking.models.Person;
import lombok.Data;

import java.util.UUID;

@Data
public class GetCarDTO {
    private UUID id;

    private String plate;

    private String brand;

    private String model;

    private String color;

    private PersonDTO person;
}
