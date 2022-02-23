package dev.projectlion.demo.week5.mybatis.mapper;

import dev.projectlion.demo.week5.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
