package dev.projectlion.demo.week6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!local")
public class RabbitMQ implements MessageQueueInterface{
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQ.class);

    public RabbitMQ() {
        logger.info("rabbimq component");
    }

    @Override
    public String readMessage() {
        // code for communicationg with RabbitMQ
        return "meeage from rabitMq";
    }
}
