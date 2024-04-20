package com.example.dreamsapp.web.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageListener {
//    OLD
//    @RabbitListener(queues = "spring-queue")
//    public void printMessage(String message){
//        log.info("Read message from RabbitMQ: '{}'", message);
//    }

}
