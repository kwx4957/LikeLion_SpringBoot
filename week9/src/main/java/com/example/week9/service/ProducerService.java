package com.example.week9.service;

import com.example.week9.model.JobRequest;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue rabbitQueue;
    private final Gson gson;

    public ProducerService(RabbitTemplate rabbitTemplate, Queue rabbitQueue, Gson gson){
        this.rabbitQueue = rabbitQueue;
        this.rabbitTemplate = rabbitTemplate;
        this.gson = gson;
    }

    public String  send(){
        JobRequest jobRequest = new JobRequest(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(rabbitQueue.getName(), jobRequest);
        logger.info("sent msg,{}",gson.toJson(jobRequest));
        return jobRequest.getJobId();
    }
}
