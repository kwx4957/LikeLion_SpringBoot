package dev.projectlion.demo.week4.answer.basic.controller;

import dev.projectlion.demo.week4.answer.basic.model.PostDto;
import dev.projectlion.demo.week4.answer.basic.repository.PostBasicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("board/{boardId}/post")
public class PostBasicController {
    private final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final PostBasicRepository postBasicRepository;

    public PostBasicController(PostBasicRepository postBasicRepository){
        this.postBasicRepository = postBasicRepository;
    }

    @PostMapping()
    public ResponseEntity<PostDto> createPost(@PathVariable("boardId") Long boardId,@RequestBody PostDto dto){
        PostDto postDto = this.postBasicRepository.create(boardId,dto);
        return ResponseEntity.ok(postDto.passwordMasked());
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> readPost(@PathVariable("boardId") Long boardId,@PathVariable("postId") Long postId){
        PostDto dto = this.postBasicRepository.read(boardId ,postId);
        if (dto == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(dto.passwordMasked());
        }
    }

    @GetMapping()
    public ResponseEntity<Collection<PostDto>> readPostAll(@PathVariable("boardId") Long boardId){
        Collection<PostDto> postDtoCollection = this.postBasicRepository.readAll(boardId);
        if (postDtoCollection == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(postDtoCollection);
        }
    }

    @PutMapping("{postId}")
    public ResponseEntity<?> updateBoard(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @RequestBody PostDto dto){

        if(!this.postBasicRepository.update(boardId,postId,dto)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deleteBoard(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @RequestParam("password") String password){

        if(!this.postBasicRepository.delete(boardId,postId,password)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
