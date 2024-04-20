package com.example.dreamsapp.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "persons")
public class Person {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String first_name;

    private String last_name;

    @JsonManagedReference
    @JsonIgnore
    @Setter(AccessLevel.PRIVATE)
    @BatchSize(size = 100) //when lazy then its better to select for 100 persons immediately. it will be faster than for every person select note
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();

    @OneToMany
    @Setter(AccessLevel.PRIVATE)
    @JsonManagedReference
    @JsonIgnore
    private List<Goal> goals = new ArrayList<>();
}
