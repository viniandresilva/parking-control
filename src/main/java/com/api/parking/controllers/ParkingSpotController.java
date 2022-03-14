package com.api.parking.controllers;

import com.api.parking.dtos.ParkingSpot.GetParkingSpotDTO;
import com.api.parking.dtos.ParkingSpot.ListParkingSpotDTO;
import com.api.parking.dtos.ParkingSpot.ParkingSpotDTO;
import com.api.parking.models.ParkingSpot;
import com.api.parking.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public record ParkingSpotController(ParkingSpotService service) {
    @GetMapping
    public List<ListParkingSpotDTO> list() {
        return service.list();
    }

    @GetMapping(value = "/{id}")
    public GetParkingSpotDTO get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody  @Valid ParkingSpotDTO parkingSpotDto) {
        if(service.existsParkingSpotByNumberAndApartment(parkingSpotDto.getNumber(), parkingSpotDto.getApartment()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: Parking Spot already in use!");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(parkingSpotDto));
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid ParkingSpot parkingSpot) {
        service.delete(parkingSpot);
    }
}
