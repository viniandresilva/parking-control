package com.api.parking.services;

import com.api.parking.models.Person;
import com.api.parking.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public record PersonService(PersonRepository repository) {

    public Person save(Person person){
        return repository.save(person);
    }
}