package com.example.week9.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final RabbitTemplate rabbitTemplate;
    private final Queue rabbitQueue;

    public ProducerService(RabbitTemplate rabbitTemplate,Queue rabbitQueue){
        this.rabbitQueue = rabbitQueue;
        this.rabbitTemplate = rabbitTemplate;
    }

    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    public void send(){
        StringBuilder builder = new StringBuilder("hello");
        if (dots.incrementAndGet() == 4){
            dots.set(1);
        }
        builder.append(".".repeat(dots.get()));
        builder.append(count.incrementAndGet());
        String msg = builder.toString();

        rabbitTemplate.convertAndSend(rabbitQueue.getName(), msg);
        logger.info("sent msg,{}",msg);

    }
}
