package com.example.dreamsapp.web.controllers;

import com.example.dreamsapp.data.dto.PersonDto;
import com.example.dreamsapp.data.model.Person;
import com.example.dreamsapp.data.services.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/persons")
@Slf4j
@RestController
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @ResponseStatus
    public Page<Person> findAll(Pageable pageable){
        return personService.findAll(pageable);
    }
    @GetMapping("/{personId}")
    @Cacheable("persons")
    @ResponseStatus
    public Person findPerson(@PathVariable Long personId){
        log.info("Searching a person");
        return personService.findOne(personId);

    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @PatchMapping("/{personId}")
    public Person updatePerson(@RequestBody Person updatedPerson, @PathVariable Long personId){
        Person person = personService.updatePerson(updatedPerson, personId);


        return person;
    }

    @GetMapping("/{personId}/goals")
    public PersonDto getPersonWithGoals(@PathVariable Long personId){
        return personService.getWithGoalsById(personId);
    }


}
