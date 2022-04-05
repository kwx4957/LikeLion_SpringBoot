package com.example.week9publisher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PublisherService {
    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    public PublisherService(RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
    }

    AtomicInteger count = new AtomicInteger(0);

    public void publishMsg(){
        String msg ="Msg count:" + count.incrementAndGet();
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),"",msg);
    }
}
