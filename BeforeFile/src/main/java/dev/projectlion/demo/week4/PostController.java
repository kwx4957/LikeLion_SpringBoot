package dev.projectlion.demo.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService){
        this.postService = postService;
    }

    @PostMapping("/create")
    public void createDto(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping("/read")
    public List<PostDto> readPostALl(){
        logger.info("read everything");
        return this.postService.readALl();
    }

    @GetMapping("/readOne")
    public PostDto readPostOne(@RequestParam("id") int id ){
        logger.info("read one");
        return this.postService.readOne(id);
    }

    @PostMapping("/update")
    public void updatePost(@RequestParam("id") int id, @RequestBody PostDto postDto){
        logger.info("target id "+ id);
        logger.info("update id "+ id);
        this.postService.updatePost(id,postDto);
    }

    @DeleteMapping("/delete")
    public void  deletePost(@RequestParam("id") int id ){
        this.postService.deletePost(id);
    }
}
