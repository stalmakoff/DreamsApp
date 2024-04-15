package com.example.dreamsapp.data.services;

import com.example.dreamsapp.data.model.Note;
import com.example.dreamsapp.data.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional(readOnly = true)
    public List<Note> findAll(){
        return noteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Note> findAllByPersonId(Long personId){
        return noteRepository.findAllByPersonId(personId);
    }

    public Note addNote(Note note){
        return noteRepository.save(note);
    }

}
