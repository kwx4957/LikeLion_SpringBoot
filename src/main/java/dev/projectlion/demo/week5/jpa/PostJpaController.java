package dev.projectlion.demo.week5.jpa;

import com.google.gson.Gson;
import dev.projectlion.demo.week6.ValidTestDto;
import dev.projectlion.demo.week6.aspect.LogExecutionTime;
import dev.projectlion.demo.week6.aspect.LogArgument;
import dev.projectlion.demo.week6.aspect.LogReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostJpaController {
    private static final Logger logger = LoggerFactory.getLogger(PostJpaController.class);
    private final PostJpaService postJpaService;

    public PostJpaController(PostJpaService postJpaService, Gson gson){
        this.postJpaService = postJpaService;
        logger.info(gson.toString());
    }
    @LogArgument
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody PostJpaDto dto){
        this.postJpaService.createPost(dto);
    }

    @LogReturn
    @GetMapping("{id}")
    public PostJpaDto readPost(@PathVariable("id") int id){
        return this.postJpaService.readPost(id);
    }

    @LogExecutionTime
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

    @PostMapping("testValid")
    public void testValid(@Valid @RequestBody ValidTestDto validTestDto){
        logger.warn(validTestDto.toString());
    }
}
