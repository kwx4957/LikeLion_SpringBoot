package dev.projectlion.demo.week5.mybatis.mapper;

import dev.projectlion.demo.week5.mybatis.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto);
    int createPostAll(List<PostDto> dtolist);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto dto);
    int updatePost(PostDto dto);
    int deletePost(int id);
}
