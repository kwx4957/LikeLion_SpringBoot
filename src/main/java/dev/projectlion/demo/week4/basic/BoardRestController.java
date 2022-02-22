package dev.projectlion.demo.week4.basic;

import dev.projectlion.demo.week4.basic.board.BoardDto;
import dev.projectlion.demo.week4.basic.board.BoardService;
import dev.projectlion.demo.week4.basic.post.PostDto;
import dev.projectlion.demo.week4.basic.post.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
    private final BoardService boardService;
    private final PostService postService;

    public BoardRestController(BoardService boardService, PostService postService) {
        this.boardService = boardService;
        this.postService = postService;
    }

    // GET /api/{board} 게시판 전체
    // GET /api/{board}/{id} 게시글
    // Post /api/{board} 게시글 작성
    // PUT /api/{id} 게시글 수정
    // DELETE /api/{id} 게시글 삭제

    @GetMapping("/{board}")
    public List<BoardDto> readPostAll(@PathVariable("board") String board){
        logger.info("Real all Post in " + board);
        return this.boardService.readALl(board);
    }

    @PostMapping("/{board}")
    public  void createBoard(@PathVariable("board") String board, @RequestBody PostDto postDto){
        logger.info(postDto.toString()+board);
        this.postService.createPost(board ,postDto);
    }

    @GetMapping("/{board}/{id}")
    public Optional<PostDto> readOne(@PathVariable("board") String board, @PathVariable("id") int id ){
        logger.info(board + id );
        return this.postService.readOne(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto){
        logger.info("target id "+ id);
        logger.info("update contents  "+ postDto);
        this.postService.updatePost(id,postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") int id, @RequestParam PostDto postDto){
        logger.info("delete contents  "+ postDto);
        this.postService.deletePost(id, postDto);
    }
}
