package dev.projectlion.demo.week4;

import java.util.List;

public interface PostService {
    void createPost(PostDto postDto);
    List<PostDto> readALl();
    PostDto readOne(int id);
    void updatePost(int id,PostDto postDto);
    void deletePost(int id);
}
