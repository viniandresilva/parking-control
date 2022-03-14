package com.api.parking.controllers;

import com.api.parking.dtos.Car.CarDTO;
import com.api.parking.dtos.Car.GetCarDTO;
import com.api.parking.dtos.Car.ListCarDTO;
import com.api.parking.models.Car;
import com.api.parking.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car")
public record CarController(CarService service) {

    @GetMapping
    public List<ListCarDTO> list() {
        return service.list();
    }

    @GetMapping(value = "/{id}")
    public GetCarDTO get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CarDTO carDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(carDto));
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid Car car) {
        service.delete(car);
    }
}
