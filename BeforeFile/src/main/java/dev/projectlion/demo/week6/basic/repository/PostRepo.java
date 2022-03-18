package dev.projectlion.demo.week6.basic.repository;

import dev.projectlion.demo.week6.basic.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<PostEntity,Long> {
}
