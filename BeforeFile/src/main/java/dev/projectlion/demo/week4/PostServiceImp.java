package dev.projectlion.demo.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements  PostService{
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImp.class);
    private final PostRepository postRepository;

    public PostServiceImp(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto postDto) {
        // TODO
        if (!this.postRepository.save(postDto)) {
            throw  new RuntimeException("save failed");
        }

    }

    @Override
    public List<PostDto> readALl() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readOne(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
        this.postRepository.update(id,postDto);
    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);
    }
}
