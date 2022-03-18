package dev.projectlion.demo.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostInMemoryRepository implements PostRepository{
    private static final Logger logger = LoggerFactory.getLogger(PostInMemoryRepository.class);
    private final List<PostDto> postDtoList;

    public PostInMemoryRepository() {
        this.postDtoList = new ArrayList<>();
    }

    @Override
    public List<PostDto> findAll() {
        return this.postDtoList;
    }

    @Override
    public PostDto findById(int id) {
        return this.postDtoList.get(id);
    }

    @Override
    public boolean save(PostDto dto) {
        return this.postDtoList.add(dto);
    }

    @Override
    public boolean delete(int id) {
        postDtoList.remove(id);
        return true;
    }

    @Override
    public boolean update(int id, PostDto dto) {
        PostDto targetPost = this.postDtoList.get(id);
        if (dto.getTitle() != null){
            targetPost.setTitle(dto.getTitle());
        }

        if (dto.getContent() != null){
            targetPost.setContent(dto.getContent());
        }

        this.postDtoList.set(id,targetPost);

        return true;
    }
}
