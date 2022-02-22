package com.api.parking.controllers;

import com.api.parking.services.ParkingSpotService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public record ParkingSpotController(ParkingSpotService service) {
}
