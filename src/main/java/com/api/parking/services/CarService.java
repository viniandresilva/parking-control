package com.api.parking.services;

import com.api.parking.dtos.Car.CarDTO;
import com.api.parking.dtos.Car.GetCarDTO;
import com.api.parking.dtos.Car.ListCarDTO;
import com.api.parking.models.Car;
import com.api.parking.repositories.ApartmentRepository;
import com.api.parking.repositories.CarRepository;
import com.api.parking.repositories.PersonRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    CarRepository carRepository;
    PersonRepository personRepository;
    ModelMapper mapper;

    CarService(CarRepository carRepository, PersonRepository personRepository, ModelMapper mapper) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    public List<ListCarDTO> list() {
        return mapper.map(carRepository.findAll(), new TypeToken<List<ListCarDTO>>(){}.getType());
    }

    public GetCarDTO get(UUID id) {
        return mapper.map(carRepository.findById(id).get(), GetCarDTO.class);
    }

    @Transactional
    public GetCarDTO save(CarDTO carDto){
        Car car = mapper.map(carDto, Car.class);
        car.setPerson(personRepository.getById(carDto.getPerson()));
        carRepository.save(car);
        return mapper.map(car, GetCarDTO.class);
    }

    @Transactional
    public void delete(Car car) {
        carRepository.delete(car);
    }
}
