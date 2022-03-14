package com.api.parking.services;

import com.api.parking.dtos.Apartment.ApartmentDTO;
import com.api.parking.dtos.Apartment.GetApartmentDTO;
import com.api.parking.dtos.Apartment.ListApartmentDTO;
import com.api.parking.models.Apartment;
import com.api.parking.repositories.ApartmentRepository;
import com.api.parking.repositories.PersonRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ApartmentService {
    ApartmentRepository apartmentRepository;
    PersonRepository personRepository;
    ModelMapper mapper;

    ApartmentService(ApartmentRepository apartmentRepository, PersonRepository personRepository, ModelMapper mapper) {
        this.apartmentRepository = apartmentRepository;
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    public List<ListApartmentDTO> list() {
        return mapper.map(apartmentRepository.findAll(), new TypeToken<List<ListApartmentDTO>>(){}.getType());
    }

    public GetApartmentDTO get(UUID id) {
        return mapper.map(apartmentRepository.findById(id).get(), GetApartmentDTO.class);
    }

    @Transactional
    public GetApartmentDTO save(ApartmentDTO apartmentDTO){
        Apartment apartment =  mapper.map(apartmentDTO, Apartment.class);
        apartment.setPerson(personRepository.getById(apartmentDTO.getPerson()));
        apartmentRepository.save(apartment);
        return mapper.map(apartment, GetApartmentDTO.class);
    }

    @Transactional
    public void delete(Apartment apartment) {
        apartmentRepository.delete(apartment);
    }
}
