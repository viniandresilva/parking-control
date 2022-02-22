package com.api.parking.controllers;

import com.api.parking.dtos.PersonDto;
import com.api.parking.models.Person;
import com.api.parking.services.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/person")
public record PersonController(PersonService service) {

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PersonDto personDto){
        var person = new Person();
        BeanUtils.copyProperties(personDto, person);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(person));
    }
}
