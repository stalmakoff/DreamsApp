package com.example.dreamsapp.web.client;

import com.example.dreamsapp.data.dto.GoalDto;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;


@Component
@RequiredArgsConstructor
public class GoalsClientOld {

    private final DiscoveryClient discoveryClient;

    private final WebClient webClient;


    public List<GoalDto> getGoalByPersonId(@RequestParam Long personId){
        var goalInstances = discoveryClient.getInstances("goals");
        var goalInstance = goalInstances.get(0);
        var goalUrl = goalInstance.getUri()+"/goals?personId="+personId;
        List<GoalDto> result = webClient.get()
                .uri(goalUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GoalDto>>() {}).block();


        return result;
    }

}
