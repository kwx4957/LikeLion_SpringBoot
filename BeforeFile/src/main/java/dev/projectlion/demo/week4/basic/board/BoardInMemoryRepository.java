package dev.projectlion.demo.week4.basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BoardInMemoryRepository implements BoardRepository {
    private static final Logger logger = LoggerFactory.getLogger(BoardInMemoryRepository.class);
    private final List<BoardDto> boardDtoList;
    int id = 1;

    public BoardInMemoryRepository() {
        this.boardDtoList = new ArrayList<>();
    }

    @Override
    public boolean saveBoard(String board, int postId) {

        BoardDto boardDto = new BoardDto(increaseId(),board,postId);
        if (board == null){
            throw new RuntimeException("게시판이 없잔혀");
        }

        this.boardDtoList.add(boardDto);
        logger.info("글이 잘저장댐"+this.boardDtoList);
        return true;
    }

    @Override
    public List<BoardDto> findAllByBoard(String boards) {
        logger.info("글이 없나유?"+ this.boardDtoList);
        return this.boardDtoList.stream()
                .filter(BoardDto -> BoardDto.getBoard().equals(boards))
                .collect(Collectors.toList());
    }

    private int increaseId(){
        return this.id++;

    }

}
