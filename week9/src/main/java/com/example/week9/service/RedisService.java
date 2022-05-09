package com.example.week9.service;

import com.example.week9.model.JobProcess;
import com.example.week9.repository.RedisRepopsitory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RedisService {
    private final RedisRepopsitory redisRepopsitory;

    public RedisService(RedisRepopsitory redisRepopsitory) {
        this.redisRepopsitory = redisRepopsitory;
    }

    public JobProcess retreiveJob(String jobId){
        Optional<JobProcess> jobProcess = this.redisRepopsitory.findById(jobId);
        if (jobProcess.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return jobProcess.get();
    }
}
