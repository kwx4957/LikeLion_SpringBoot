package dev.projectlion.demo.week4.basic.post;

import java.util.Optional;

public interface PostRepository {
    Optional<PostDto> findById(int id);
    boolean save(PostDto dto);
    void delete(int id, PostDto dto);
    void update(int id, PostDto dto);
}
