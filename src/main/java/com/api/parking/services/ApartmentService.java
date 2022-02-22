package com.api.parking.services;

import com.api.parking.repositories.ApartmentRepository;
import org.springframework.stereotype.Service;

@Service
public record ApartmentService(ApartmentRepository repository) {

}
