package com.example.dreamsapp.data.repositories;

import com.example.dreamsapp.data.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query("select n from Note n left join fetch n.person p where n.person.id = :personId")
    List<Note> findAllByPersonId(@Param("personId") Long personId);
}
