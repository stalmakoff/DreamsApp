package com.example.dreamappgoals.repository;

import com.example.dreamappgoals.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findAllByPersonId(Long personId);
}
