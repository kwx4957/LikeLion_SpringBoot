package dev.projectlion.demo.week4.basic.board;

import java.util.List;

public interface BoardRepository {
    List<BoardDto> findAllByBoard(String board);
    boolean saveBoard(String board, int postId);
}
