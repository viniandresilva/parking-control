package com.api.parking.dtos.Apartment;

import com.api.parking.models.Person;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class ApartmentDTO {
    private UUID id;

    @NotNull
    private Integer number;

    @NotBlank
    @NotNull
    @Size(max = 10, message = "number must be a maximum of 10 characters")
    private String block;

    @NotNull
    private UUID person;
}
