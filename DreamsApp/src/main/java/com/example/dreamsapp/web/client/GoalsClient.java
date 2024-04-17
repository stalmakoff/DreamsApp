package com.example.dreamsapp.web.client;

import com.example.dreamsapp.data.dto.GoalDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient("goals")
public interface GoalsClient {
    @GetMapping("/goals")
    @CircuitBreaker(name="goal-service", fallbackMethod = "defaultList")
    public List<GoalDto> getGoalByPersonId(@RequestParam Long personId);

    default List<GoalDto> defaultList(Throwable throwable){
        List<GoalDto> defaultList = new ArrayList<>();
        defaultList.add(new GoalDto(1L, "Default"));
        return defaultList;
    }
}
