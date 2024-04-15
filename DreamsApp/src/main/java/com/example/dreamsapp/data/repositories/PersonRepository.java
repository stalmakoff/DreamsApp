package com.example.dreamsapp.data.repositories;

import com.example.dreamsapp.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
