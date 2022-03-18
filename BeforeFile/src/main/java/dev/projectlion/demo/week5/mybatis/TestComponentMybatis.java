package dev.projectlion.demo.week5.mybatis;

import dev.projectlion.demo.week5.mybatis.dao.BoardDao;
import dev.projectlion.demo.week5.mybatis.dao.PostDao;
import org.springframework.stereotype.Component;

@Component
public class TestComponentMybatis {
    private final PostDao postDao;
    private final BoardDao boardDao;

    public TestComponentMybatis(PostDao postDao, BoardDao boardDao) {
        this.boardDao = boardDao;
        this.postDao = postDao;

    }


}
