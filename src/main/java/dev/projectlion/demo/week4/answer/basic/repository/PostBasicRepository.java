package dev.projectlion.demo.week4.answer.basic.repository;

import dev.projectlion.demo.week4.answer.basic.model.BoardDto;
import dev.projectlion.demo.week4.answer.basic.model.PostDto;

import java.util.Collection;

public interface PostBasicRepository {
    PostDto create(Long boardId, PostDto dto);
    PostDto read(Long boardId, Long postId);
    Collection<PostDto> readAll(Long boardId);
    boolean update(Long boardId, Long postId ,PostDto dto);
    boolean delete(Long boardId, Long postId ,String password);
}
