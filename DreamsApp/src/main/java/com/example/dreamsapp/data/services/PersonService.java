package com.example.dreamsapp.data.services;

import com.example.dreamsapp.data.dto.PersonDto;
import com.example.dreamsapp.data.model.Person;
import com.example.dreamsapp.data.repositories.NoteRepository;
import com.example.dreamsapp.data.repositories.PersonRepository;
import com.example.dreamsapp.web.client.GoalsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final NoteService noteService;
    private final GoalsClient goalsClient;

    private final NoteRepository noteRepository;

//    private final DiscoveryClient discoveryClient; we can do discovery + with RestTemplate but we will do easier. all is written already for us

    public Page<Person> findAll(Pageable pageable){
        return personRepository.findAll(pageable);
    }
    @Transactional(readOnly = true)
    public Person findOne(Long personId) {
        return personRepository.findById(personId).orElseThrow(()-> new RuntimeException("Person not found!"));
    }

    @Transactional(readOnly = true)
    public Person createPerson(Person person){
        return personRepository.save(person);
    }


    public Person updatePerson(Person updatedPerson, Long personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        person.setFirst_name(updatedPerson.getFirst_name());
        person.setLast_name(updatedPerson.getLast_name());
        return person;
    }

    public PersonDto getWithGoalsById(Long personId){
        //load person from the DB
        //call goals service
        //create PersonDto
        var person = personRepository.findById(personId).orElseThrow();
        var goals = goalsClient.getGoalByPersonId(personId);
        var notes = noteService.findAllByPersonId(personId);
        return new PersonDto(person.getFirst_name(), person.getLast_name(), notes, goals);



//        List<ServiceInstance> goalInstances = discoveryClient.getInstances("goals"); already redundant, we can write easier. see above
//        var instance = goalInstances.get(0);
    }

}
