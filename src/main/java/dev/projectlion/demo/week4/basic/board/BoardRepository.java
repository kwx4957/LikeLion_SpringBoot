package dev.projectlion.demo.week4.basic.board;

import dev.projectlion.demo.week4.basic.post.PostDto;

import java.util.List;

public interface BoardRepository {
    List<BoardDto> findAllByBoard(String board);
    boolean saveBoard(String board, int postId);
}
