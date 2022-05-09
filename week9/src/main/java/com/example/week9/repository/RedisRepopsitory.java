package com.example.week9.repository;

import com.example.week9.model.JobProcess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepopsitory extends CrudRepository<JobProcess, String> {
}
