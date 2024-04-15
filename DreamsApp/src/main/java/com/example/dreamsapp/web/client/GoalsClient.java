package com.example.dreamsapp.web.client;

import com.example.dreamsapp.data.dto.GoalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("goals")
public interface GoalsClient {
    @GetMapping("/goals")
    public List<GoalDto> getGoalByPersonId(@RequestParam Long personId);


}
