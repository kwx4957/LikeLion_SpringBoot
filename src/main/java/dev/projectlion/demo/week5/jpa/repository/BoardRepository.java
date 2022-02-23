package dev.projectlion.demo.week5.jpa.repository;

import dev.projectlion.demo.week5.jpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
