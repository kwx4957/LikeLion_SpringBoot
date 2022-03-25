package dev.projectlion.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.projectlion.demo.week4.answer.basic.controller.BoardController;
import dev.projectlion.demo.week4.answer.basic.model.BoardDto;
import dev.projectlion.demo.week4.basic.BoardRestController;
import dev.projectlion.demo.week4.basic.board.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.io.IOException;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardRestController.class)
public class BoardCtrollerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    @DisplayName("createBoard")
    void createBoard() throws Exception {
        //given
        BoardDto boardDto = new BoardDto();
        boardDto.setName("주식");

        //when
        final ResultActions actions = mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(boardDto)))
                .andDo(print());

        //then
        actions.andExpectAll(
                status().is2xxSuccessful(),
                (ResultMatcher) content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                (ResultMatcher) jsonPath("$.name",is("주식"))
        );
    }

    private byte[] toJson(Object object) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
