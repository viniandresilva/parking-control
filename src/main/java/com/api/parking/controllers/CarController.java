package com.api.parking.controllers;

import com.api.parking.services.CarService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car")
public record CarController(CarService service) {

}
