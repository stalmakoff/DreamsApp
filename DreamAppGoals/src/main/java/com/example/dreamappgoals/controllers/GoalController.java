package com.example.dreamappgoals.controllers;

import com.example.dreamappgoals.domain.Goal;
import com.example.dreamappgoals.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goals")
public class GoalController {

    private final GoalRepository goalRepository;

    @GetMapping
    public List<Goal> getGoalByPersonId(@RequestParam Long personId){
        return goalRepository.findAllByPersonId(personId);
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal){
        return goalRepository.save(goal);
    }
}
