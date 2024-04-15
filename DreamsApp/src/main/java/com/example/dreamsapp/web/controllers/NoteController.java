package com.example.dreamsapp.web.controllers;

import com.example.dreamsapp.data.model.Note;
import com.example.dreamsapp.data.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/notes")
@RestController
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    @ResponseStatus
    public List<Note> notes(){
        return noteService.findAll();
    }

    @PostMapping
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

}
