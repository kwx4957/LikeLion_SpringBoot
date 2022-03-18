package dev.projectlion.demo.week5.jpa;

import dev.projectlion.demo.week5.jpa.entity.BoardEntity;
import dev.projectlion.demo.week5.jpa.entity.PostEntity;
import dev.projectlion.demo.week5.jpa.repository.BoardRepository;
import dev.projectlion.demo.week5.jpa.repository.PostRepository;
import org.springframework.stereotype.Component;

@Component
public class TestComponentJpa {

    public TestComponentJpa(BoardRepository boardRepository, PostRepository postRepository){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("new board");
        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
        System.out.println(newBoardEntity.getName());

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("first jpa");
        postEntity.setContent("hello ");
        postEntity.setWriter("hello hello helllo");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);

        System.out.println(postRepository.findAllByWriter("hello hello helllo").size());

    }
}
