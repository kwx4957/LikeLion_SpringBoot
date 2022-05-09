package com.example.week9.controller;

import com.example.week9.model.JobProcess;
import com.example.week9.service.ProducerService;
import com.example.week9.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private final ProducerService producerService;
    private final RedisService redisService;

    public ProducerController(ProducerService producerService, RedisService redisService) {
        this.producerService = producerService;
        this.redisService = redisService;
    }

    @GetMapping("/")
    public String sendMsg(){
      return producerService.send();
    }

    @GetMapping("/{jobId}")
    public JobProcess getResult(@PathVariable("jobId") String jobId){
        return redisService.retreiveJob(jobId);
    }


}
