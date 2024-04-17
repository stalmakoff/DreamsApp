package com.example.dreamsapp.web.client;

import com.example.dreamsapp.data.dto.GoalDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class GoalsClientOld {

    private final DiscoveryClient discoveryClient;

    private final WebClient webClient;

    private final CircuitBreakerFactory circuitBreakerFactory;

    @CircuitBreaker(name="goal-service", fallbackMethod = "defaultList") //creates Proxy of this class and webclient call makes with circuitbreaker + default if fails
    public List<GoalDto> getGoalByPersonId(@RequestParam Long personId){
        var goalInstances = discoveryClient.getInstances("goals");
        var goalInstance = goalInstances.get(0);
        var goalUrl = goalInstance.getUri()+"/goals?personId="+personId;
        List<GoalDto> result;
        result = webClient.get()
                .uri(goalUrl)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GoalDto>>() {}).block();


      //OLD(CAN MAKE EASIER)
//        result =  circuitBreakerFactory.create("goal-service") //calling not direct, but using circuitBreaker and circuit breaker will monitor and make statistics for every request(is it successful or not and how many secs) and compare with properties
//                .run(()-> webClient.get()
//                        .uri(goalUrl)
//                        .retrieve()
//                        .bodyToMono(new ParameterizedTypeReference<List<GoalDto>>() {}).block(), throwable -> new ArrayList<>()); //when call fails(works circuitbreaker) than default list
//
//


        return result;
    }

    public List<GoalDto> defaultList(Throwable throwable){
        List<GoalDto> defaultList = new ArrayList<>();
        defaultList.add(new GoalDto(1L, "Default"));
        return defaultList;
    }

}
