package dev.projectlion.demo.week5.jpa;

import dev.projectlion.demo.DemoApplication;
import dev.projectlion.demo.week5.jpa.entity.PostEntity;
import dev.projectlion.demo.week5.jpa.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DemoApplication.class
)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureTestDatabase
public class PostControllerIntergrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Before
    public void setEntities(){
        createTestPost("post1","content1","lieklion1");
        createTestPost("post2","content2","lieklion2");
    }

    @Test
    public void givenValidId_whenReadPost_then200() throws Exception{
        // given
        Long id = createTestPost("rest post", "create readPost" , "woowhaa");

        //when
        final ResultActions actions = mockMvc.perform(get("/post/{id}",id))
                .andDo(print());

        //then
        actions.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.title",is("rest post")),
                jsonPath("$.content",is("create readPost"))
        );
    }

    private Long createTestPost(String title, String content, String writer){
        PostEntity postEntity =new PostEntity();
        postEntity.setTitle(title);
        postEntity.setContent(content);
        postEntity.setWriter(writer);
        return postRepository.save(postEntity).getId();
    }
}
