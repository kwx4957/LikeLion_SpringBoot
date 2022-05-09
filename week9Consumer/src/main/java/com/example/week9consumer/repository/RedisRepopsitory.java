package com.example.week9consumer.repository;

import com.example.week9consumer.model.JobProcess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepopsitory extends CrudRepository<JobProcess, String> {
}
