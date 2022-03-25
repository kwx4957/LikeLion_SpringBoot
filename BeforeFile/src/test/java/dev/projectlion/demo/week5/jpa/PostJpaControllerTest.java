package dev.projectlion.demo.week5.jpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostJpaController.class)
class PostJpaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostJpaService postJpaService;

    @Test
    void readPost() throws Exception {
        final int id = 10;
        PostJpaDto testDto = new PostJpaDto();
        testDto.setId(id);
        testDto.setTitle("Hello");
        testDto.setContent("Unit Content");
        testDto.setWriter("Dansam");

        given(postJpaService.readPost(id)).willReturn(testDto);
        //given 어떠한 데이터가 준비 되어있다.
        // PostEntity가 존재할때

        //when 어떤 행위가 일어날떄 함수호출
        // GET 요청이 오면
        final ResultActions actions = mockMvc.perform(get("/post/{id}",id))
                .andDo(print());

        //then 어떤 결과가 올것인지
        //PostDto가 반환된다
        actions.andExpectAll(
                status().isOk(),
                content().contentType(MediaType.APPLICATION_JSON),
                jsonPath("$.title",is("Hello")),
                jsonPath("$.content",is("Unit Content")),
                jsonPath("$.writer",is("Dansam"))
        );
    }

    @Test
    void readPostAll() throws Exception {
        PostJpaDto post1 = new PostJpaDto();
        post1.setTitle("title 1");
        post1.setContent("conetns 2 ");
        post1.setWriter("Dansam");

        PostJpaDto post2 = new PostJpaDto();
        post2.setTitle("title 1");
        post2.setContent("conetns 2");
        post2.setWriter("Dansam");

        List<PostJpaDto> postJpaDtoList = Arrays.asList(post1,post2);
        given(postJpaService.readPostAll()).willReturn(postJpaDtoList);

        final ResultActions actions = mockMvc.perform(get("/post"))
                .andDo(print());

        actions.andExpectAll(
            status().isOk(),
            content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
            jsonPath("$",hasSize(postJpaDtoList.size()))
        );
    }
}