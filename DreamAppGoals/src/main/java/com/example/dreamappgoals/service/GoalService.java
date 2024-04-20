package com.example.dreamappgoals.service;

import com.example.dreamappgoals.domain.Goal;
import com.example.dreamappgoals.event.GoalUpdatedEvent;
import com.example.dreamappgoals.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;
    private final StreamBridge streamBridge;

    @Transactional(readOnly = true)
    public List<Goal> findAllByPersonId(Long personId){
        return goalRepository.findAllByPersonId(personId);
    }


    public Goal updateGoal(Goal goal) {
        Goal savedGoal = goalRepository.findById(goal.getId()).orElseThrow();
        savedGoal.setId(goal.getId());
        savedGoal.setName(goal.getName());
        streamBridge.send("goals-topic", new GoalUpdatedEvent(goal.getId())); //event in goals-topic
        return savedGoal;
    }
}
