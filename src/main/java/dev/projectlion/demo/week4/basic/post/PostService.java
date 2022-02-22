package dev.projectlion.demo.week4.basic.post;

import java.util.Optional;

public interface PostService {
    void createPost(String board, PostDto postDto);
    Optional<PostDto> readOne(int id);
    void updatePost(int id, PostDto postDto);
    void deletePost(int id, PostDto dto);
}
