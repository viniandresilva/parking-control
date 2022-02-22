package com.api.parking.services;

import com.api.parking.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service
public record ParkingSpotService(ParkingSpotRepository repository) {

}