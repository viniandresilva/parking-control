package com.api.parking.services;

import com.api.parking.dtos.Person.GetPersonDTO;
import com.api.parking.dtos.Person.ListPersonDTO;
import com.api.parking.dtos.Person.PersonDTO;
import com.api.parking.models.ParkingSpot;
import com.api.parking.models.Person;
import com.api.parking.repositories.PersonRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    PersonRepository repository;
    ModelMapper mapper;

    PersonService(PersonRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ListPersonDTO> list() {
        return mapper.map(repository.findAll(), new TypeToken<List<ListPersonDTO>>(){}.getType());
    }

    public GetPersonDTO get(UUID id) {
        return mapper.map(repository.findById(id).get(), GetPersonDTO.class);
    }

    @Transactional
    public PersonDTO save(PersonDTO personDto){
        Person person = mapper.map(personDto, Person.class);
        repository.save(person);
        return mapper.map(person, PersonDTO.class);
    }

    @Transactional
    public void delete(Person person) {
        repository.delete(person);
    }
}