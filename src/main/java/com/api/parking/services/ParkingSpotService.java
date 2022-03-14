package com.api.parking.services;

import com.api.parking.dtos.ParkingSpot.GetParkingSpotDTO;
import com.api.parking.dtos.ParkingSpot.ListParkingSpotDTO;
import com.api.parking.dtos.ParkingSpot.ParkingSpotDTO;
import com.api.parking.models.Apartment;
import com.api.parking.models.ParkingSpot;
import com.api.parking.repositories.ApartmentRepository;
import com.api.parking.repositories.CarRepository;
import com.api.parking.repositories.ParkingSpotRepository;
import com.api.parking.repositories.PersonRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ParkingSpotService {
    ParkingSpotRepository parkingSpotRepository;
    ApartmentRepository apartmentRepository;
    ModelMapper mapper;

    ParkingSpotService(ParkingSpotRepository parkingSpotRepository, ApartmentRepository apartmentRepository, ModelMapper mapper) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.apartmentRepository = apartmentRepository;
        this.mapper = mapper;
    }
    public List<ListParkingSpotDTO> list() {
        return mapper.map(parkingSpotRepository.findAll(), new TypeToken<List<ListParkingSpotDTO>>(){}.getType());
    }

    public GetParkingSpotDTO get(UUID id) {
        return mapper.map(parkingSpotRepository.findById(id).get(), GetParkingSpotDTO.class);
    }

    @Transactional
    public GetParkingSpotDTO save(ParkingSpotDTO parkingSpotDTO){
        ParkingSpot parkingSpot = mapper.map(parkingSpotDTO, ParkingSpot.class);
        parkingSpot.setApartment(apartmentRepository.getById(parkingSpotDTO.getApartment()));
        parkingSpotRepository.save(parkingSpot);
        return mapper.map(parkingSpot, GetParkingSpotDTO.class);
    }

    @Transactional
    public void delete(ParkingSpot parkingSpot) {
        parkingSpotRepository.delete(parkingSpot);
    }

    public boolean existsParkingSpotByNumberAndApartment(String number, UUID apartment) {
        return parkingSpotRepository.existsParkingSpotByNumberAndApartmentId(number, apartment);
    }
}