package dev.projectlion.demo.week5.jpa.repository;

import dev.projectlion.demo.week5.jpa.entity.BoardEntity;
import dev.projectlion.demo.week5.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer);
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity);
    List<PostEntity> findAllByWriterContaining(String containingString);
}
