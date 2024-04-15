package com.example.dreamsapp.data.dto;

import com.example.dreamsapp.data.model.Note;

import java.util.List;

public record PersonDto(String firstName, String lastName, List<Note> notes, List<GoalDto> goals) {
}
