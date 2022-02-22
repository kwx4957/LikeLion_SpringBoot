package dev.projectlion.demo.week4.basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImp implements BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceImp.class);
    private final BoardRepository boardRepository;

    public BoardServiceImp(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<BoardDto> readALl(String board) {
        logger.info("board 게시판 전체 글 읽기 성공 ");
        return boardRepository.findAllByBoard(board);
    }
}
