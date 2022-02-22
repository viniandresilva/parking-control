package com.api.parking.controllers;

import com.api.parking.services.ApartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/apartment")
public record ApartmentController(ApartmentService service) {

}
