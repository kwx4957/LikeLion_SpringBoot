package dev.projectlion.demo.week4.answer.basic.repository;

import dev.projectlion.demo.week4.answer.basic.model.BoardDto;
import dev.projectlion.demo.week4.answer.basic.model.PostDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostBasicRepositoryImp implements PostBasicRepository{
    private final BoardBasicRepository boardBasicRepository;

    private Long lastIndex = 0L;
    private final Map<Long, PostDto> memory = new HashMap<>();

    public PostBasicRepositoryImp(BoardBasicRepository boardBasicRepository){
        this.boardBasicRepository = boardBasicRepository;
    }
    @Override
    public PostDto create(Long boardId, PostDto dto) {
        BoardDto boardDto = this.boardBasicRepository.read(boardId);
        if (boardDto == null){
            return null;
        }
        dto.setBoardId(boardId);
        lastIndex ++;
        dto.setId(lastIndex);
        memory.put(lastIndex,dto);
        return dto;
    }

    @Override
    public PostDto read(Long boardId, Long postId) {
        PostDto postDto = memory.getOrDefault(postId,null);
        if (postDto ==null){
            return null;
        }
        else if(!Objects.equals(postDto.getBoardId(), boardId)){
            return null;
        }
        return postDto;
    }

    @Override
    public Collection<PostDto> readAll(Long boardId) {
        if (boardBasicRepository.read(boardId) == null) return null;
        Collection<PostDto> postDtoList = new ArrayList<>();
        memory.forEach((postId,postDto) -> {
            if (Objects.equals(postDto.getBoardId(), boardId)){
                postDtoList.add(postDto);
            }
        });
        return postDtoList;
    }

    @Override
    public boolean update(Long boardId, Long postId, PostDto dto) {
        PostDto targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null){
            return false;
        }
        else if(!Objects.equals(targetPost.getBoardId(), boardId)){
            return  false;
        }
        else if (!Objects.equals(targetPost.getPassword(), dto.getPassword())){
            return false;
        }
        targetPost.setTitle(
                dto.getTitle() == null ? targetPost.getTitle() : dto.getTitle());
        targetPost.setContent(
                dto.getContent() == null ? targetPost.getContent() : dto.getContent());

        return true;
    }

    @Override
    public boolean delete(Long boardId, Long postId, String password) {
        PostDto targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null){
            return false;
        }
        else if(!Objects.equals(targetPost.getBoardId(), boardId)){
            return  false;
        }
        else if (!Objects.equals(targetPost.getPassword(), password)){
            return false;
        }
        memory.remove(postId);
        return true;
    }
}
