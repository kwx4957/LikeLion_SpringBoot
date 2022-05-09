package com.example.week9consumer.service;

import com.example.week9consumer.model.JobProcess;
import com.example.week9consumer.model.JobRequest;
import com.example.week9consumer.repository.RedisRepopsitory;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "boot.amqp.worker-queue")
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private final RedisRepopsitory redisRepopsitory;
    private final Gson gson;

    public ConsumerService(RedisRepopsitory redisRepopsitory, Gson gson) {
        this.redisRepopsitory = redisRepopsitory;
        this.gson = gson;
    }

    @RabbitHandler
    public void receive(String msg) throws InterruptedException {
        logger.info("receicevd{}",msg);
        String jobId;
        try {
            JobRequest newJob = gson.fromJson(msg,JobRequest.class);
            jobId = newJob.getJobId();

            JobProcess jobProcess = new JobProcess();
            jobProcess.setId(newJob.getJobId());
            jobProcess.setMsg("Job Being proceeds");
            jobProcess.setStatus(1);
            jobProcess.setResult("");
            redisRepopsitory.save(jobProcess);
        } catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
        Thread.sleep(5000);
        JobProcess jobProcess = new JobProcess();
        jobProcess.setId(jobId);
        jobProcess.setMsg("finished");
        jobProcess.setStatus(0);
        jobProcess.setResult("success");
        redisRepopsitory.save(jobProcess);
    }
}
