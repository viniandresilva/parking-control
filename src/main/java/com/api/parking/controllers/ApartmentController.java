package com.api.parking.controllers;

import com.api.parking.dtos.Apartment.ApartmentDTO;
import com.api.parking.dtos.Apartment.GetApartmentDTO;
import com.api.parking.dtos.Apartment.ListApartmentDTO;
import com.api.parking.models.Apartment;
import com.api.parking.services.ApartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/apartment")
public record ApartmentController(ApartmentService service) {
    @GetMapping
    public List<ListApartmentDTO> list() {
        return service.list();
    }

    @GetMapping(value = "/{id}")
    public GetApartmentDTO get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ApartmentDTO apartmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(apartmentDto));
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid Apartment apartment) {
        service.delete(apartment);
    }
}
