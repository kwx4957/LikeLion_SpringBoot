package dev.projectlion.demo.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(@Autowired PostService postService){
        this.postService = postService;
    }

    // http://localhost:8080/api/post
    // Post /api/post
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public  void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    // GET /api/post
    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("in read post all");
        return this.postService.readALl();
    }

    // GET /api/post/{id}
    @GetMapping("{id}")
    public PostDto readOne(@PathVariable("id") int id ){
        logger.info("in read One");
        return this.postService.readOne(id);
    }

    // Put /api/post/{id}
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto){
        logger.info("target id "+ id);
        logger.info("update contents  "+ postDto);
        this.postService.updatePost(id,postDto);
    }

    // Delete /api/post/{id}
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id){
        this.postService.deletePost(id);
    }
}
