package dev.projectlion.demo.week4.basic.post;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImp implements PostRepository{
    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryImp.class);
    private final List<PostDto> postDtoList;

    public PostRepositoryImp() {
        this.postDtoList = new ArrayList<>();
    }

    @Override
    public Optional<PostDto> findById(int id) {
        return this.postDtoList.stream()
                .filter(postDto -> postDto.getId() == id)
                .findFirst();
    }

    @Override
    public boolean save(PostDto dto) {

        if (dto.getPassword() == null){
            throw  new RuntimeException("패스워드가 없습니다");
        }

        if (dto.getWriter() == null){
            throw  new RuntimeException("작성자가 없습니다");
        }

        if (dto.getContent() == null){
            throw  new RuntimeException("내용이 없습니다");
        }

        if (dto.getTitle() == null){
            throw  new RuntimeException("제목이 없습니다");
        }
        this.postDtoList.add(dto);

        logger.info(this.postDtoList.toString());
        return true;
    }

    @Override
    public void delete(int id, PostDto dto) {
        PostDto targetPost = this.postDtoList.stream()
                .filter(postDto -> postDto.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("삭제할 글이 없엉쇼"));

        if (targetPost.getPassword().equals(dto.getPassword())){
            this.postDtoList.remove(targetPost);
            logger.info("delete success");
        }
    }

    @Override
    public void update(int id, PostDto dto) {
        PostDto targetPost = this.postDtoList.stream()
                .filter(postDto -> postDto.getId() == id)
                .findFirst()
                .orElseGet(() -> null);

        if (targetPost == null){
            throw new RuntimeException("글 수정을 못했어유");
        }

        if (dto.getTitle() != null){
            targetPost.setTitle(dto.getTitle());
        }

        if (dto.getContent() != null){
            targetPost.setContent(dto.getContent());
        }

        if (dto.getWriter() != null){
            targetPost.setWriter(dto.getWriter());
        }

        if (dto.getPassword() != null){
            targetPost.setPassword(dto.getPassword());
        }

    }
}
