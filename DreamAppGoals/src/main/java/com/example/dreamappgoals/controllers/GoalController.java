package com.example.dreamappgoals.controllers;

import com.example.dreamappgoals.domain.Goal;
import com.example.dreamappgoals.repository.GoalRepository;
import com.example.dreamappgoals.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goals")
public class GoalController {

    private final GoalService goalService;
    private final GoalRepository goalRepository;

    @GetMapping
    public List<Goal> getGoalByPersonId(@RequestParam Long personId) throws InterruptedException {
//        throw new RuntimeException("error"); //for test
        return goalService.findAllByPersonId(personId);
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal){
        return goalRepository.save(goal);
    }
    @PatchMapping
    public Goal updateGoal(@RequestBody Goal goal){return goalService.updateGoal(goal);}
}
