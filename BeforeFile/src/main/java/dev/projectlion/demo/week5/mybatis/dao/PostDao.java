package dev.projectlion.demo.week5.mybatis.dao;

//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {
   // private  final SqlSessionFactory sqlSessionFactory;

//    public PostDao(SqlSessionFactory sessionFactory){
//        this.sqlSessionFactory = sessionFactory;
//    }
//
//    public int createPost(PostDto dto){
//        try (SqlSession session = sqlSessionFactory.openSession()){
//            PostMapper mapper = session.getMapper(PostMapper.class);
//            return mapper.createPost(dto);
//        }
//    }
//
//    public PostDto readPost(int id){
//        try (SqlSession session = sqlSessionFactory.openSession()){
//            PostMapper mapper = session.getMapper(PostMapper.class);
//            return mapper.readPost(id);
//        }
//    }
//
//    public List<PostDto> readPostAll(){
//        try (SqlSession session = sqlSessionFactory.openSession()){
//            PostMapper mapper = session.getMapper(PostMapper.class);
//            return mapper.readPostAll();
//        }
//    }
//
//    public int updatePost(PostDto dto){
//        try (SqlSession session = sqlSessionFactory.openSession()){
//            PostMapper mapper = session.getMapper(PostMapper.class);
//            return mapper.updatePost(dto);
//        }
//    }
//
//    public int deletePost(int id){
//        try (SqlSession session = sqlSessionFactory.openSession()){
//            PostMapper mapper = session.getMapper(PostMapper.class);
//            return mapper.deletePost(id);
//        }
//    }
}
