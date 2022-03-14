package com.api.parking.controllers;

import com.api.parking.dtos.Person.GetPersonDTO;
import com.api.parking.dtos.Person.ListPersonDTO;
import com.api.parking.dtos.Person.PersonDTO;
import com.api.parking.models.Person;
import com.api.parking.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController()
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/person")
public record PersonController(PersonService service) {

    @GetMapping
    public List<ListPersonDTO> list() {
        return service.list();
    }

    @GetMapping(value = "/{id}")
    public GetPersonDTO get(@PathVariable("id") UUID id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PersonDTO personDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(personDto));
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid Person person) {
        service.delete(person);
    }
}
