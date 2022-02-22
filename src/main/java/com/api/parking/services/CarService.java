package com.api.parking.services;

import com.api.parking.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public record CarService(CarRepository repository) {

}
