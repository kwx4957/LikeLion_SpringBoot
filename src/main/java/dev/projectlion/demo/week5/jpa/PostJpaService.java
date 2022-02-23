package dev.projectlion.demo.week5.jpa;

import dev.projectlion.demo.week5.jpa.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostJpaService {
    private static final Logger logger = LoggerFactory.getLogger(PostJpaService.class);
    private final PostJpaDao postJpaDao;

    public PostJpaService(PostJpaDao postJpaDao){
        this.postJpaDao = postJpaDao;
    }

    public void createPost(PostJpaDto dto){
        this.postJpaDao.createPost(dto);
    }

    public PostJpaDto readPost(int id){
        PostEntity postEntity = this.postJpaDao.readPost(id);
        return new PostJpaDto(
                Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
    }

    public List<PostJpaDto> readPostAll(){
        Iterator<PostEntity> iterator = this.postJpaDao.readPostAll();
        List<PostJpaDto> postJpaDtoList = new ArrayList<>();
        while (iterator.hasNext()){
            PostEntity postEntity = iterator.next();
            postJpaDtoList.add(new PostJpaDto(
                    Math.toIntExact(postEntity.getId()),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
            ));
        }
        return postJpaDtoList;
    }

    public void updatePost(int id, PostJpaDto dto){
        this.postJpaDao.updatePost(id,dto);
    }

    public void deletePost(int id){
        this.postJpaDao.deletePost(id);
    }
}
