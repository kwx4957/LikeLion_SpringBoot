package com.example.week9consumer.config;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Bean
    public org.springframework.amqp.core.Queue queue(){
        return new Queue("boot.amqp.worker-queue",true,false,true);
    }

    @Bean
    public Gson gson(){
        return new Gson();
    }
}
