package dev.projectlion.demo.week6.basic.repository;

import dev.projectlion.demo.week6.basic.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
