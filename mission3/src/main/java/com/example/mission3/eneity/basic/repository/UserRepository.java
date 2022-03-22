package com.example.mission3.eneity.basic.repository;

import com.example.mission3.eneity.basic.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
