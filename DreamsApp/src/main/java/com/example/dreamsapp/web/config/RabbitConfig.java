package com.example.dreamsapp.web.config;

import com.example.dreamsapp.data.event.GoalUpdatedEvent;
import com.example.dreamsapp.data.services.GoalClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;


@Configuration
@Log4j2
@EnableRabbit
@RequiredArgsConstructor
public class RabbitConfig {

    public final GoalClientService goalClientService;

    @Bean
    public Consumer<GoalUpdatedEvent> goalUpdatedEventConsumer(){
        return event ->{
            log.info("Received an event: {}", event);
            goalClientService.synchronizeGoalById(event.goalId());
        };
    }




    //Old and just example
//    @Bean
//    public Queue localSpringQueue(){
//        return new Queue("spring-queue");
//    }
//
//    @Bean
//    public Queue externalJavaClientQueue(){
//        return new Queue("external-java-queue");
//    }
//
//    @Bean
//    public Exchange messageExchangeFanout(){
//        return new FanoutExchange("message-fanout");
//    }
//
//    @Bean
//    public Binding springQueueBinding(){
//        return BindingBuilder
//                .bind(localSpringQueue())
//                .to(messageExchangeFanout())
//                .with("")
//                .noargs(); //if there are special params then and(), if there are none then noargs()
//    }
//
//    @Bean
//    public Binding externalQueueBinding(){
//        return BindingBuilder
//                .bind(externalJavaClientQueue())
//                .to(messageExchangeFanout())
//                .with("")
//                .noargs(); //if there are special params then and(), if there are none then noargs()
//    }

}
