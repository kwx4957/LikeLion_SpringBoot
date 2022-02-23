package dev.projectlion.demo.week5.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostJpaController {
    private static final Logger logger = LoggerFactory.getLogger(PostJpaController.class);
    private final PostJpaService postJpaService;

    public PostJpaController(PostJpaService postJpaService){
        this.postJpaService = postJpaService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostJpaDto dto){
        this.postJpaService.createPost(dto);
    }

    @GetMapping("{id}")
    public PostJpaDto readPost(@PathVariable("id") int id){
        return this.postJpaService.readPost(id);
    }

    @GetMapping()
    public List<PostJpaDto> readPostAll(){
        return this.postJpaService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostJpaDto dto){
        this.postJpaService.updatePost(id,dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id){
        this.postJpaService.deletePost(id);
    }

}
