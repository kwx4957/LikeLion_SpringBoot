package dev.projectlion.demo.week4.answer.basic.repository;


import dev.projectlion.demo.week4.answer.basic.model.BoardDto;

import java.util.Collection;

public interface BoardBasicRepository {
    BoardDto create(BoardDto dto);
    BoardDto read(Long Id);
    Collection<BoardDto> readAll();
    boolean update(Long id, BoardDto dto);
    boolean delete(Long id);
}
