package com.api.parking.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PersonDto {
    private UUID id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String document;
}
