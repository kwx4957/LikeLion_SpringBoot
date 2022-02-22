package dev.projectlion.demo.week4.basic.post;

import dev.projectlion.demo.week4.basic.board.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImps implements PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostServiceImps.class);
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public PostServiceImps(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public void createPost(String board, PostDto postDto) {

         if(!this.postRepository.save(postDto)){
             throw new RuntimeException("postlist 저장안됨");
         }

        if (!this.boardRepository.saveBoard(board, postDto.getId())) {
            throw  new RuntimeException("boardlist저장안됨");
        }

    }

    @Override
    public Optional<PostDto> readOne(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public void updatePost(int id, PostDto postDto) {
        this.postRepository.update(id,postDto);
    }

    @Override
    public void deletePost(int id, PostDto dto) {
        this.postRepository.delete(id, dto);
    }
}
