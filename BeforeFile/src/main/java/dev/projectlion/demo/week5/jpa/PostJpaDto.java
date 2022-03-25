package dev.projectlion.demo.week5.jpa;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PostJpaDto {
    private int id;
    @NotBlank
    private String title;
    @NotBlank
    @Size(max = 40, message = "size under 40")
    private String content;
    @Size(min = 3, max = 10, message = "size btn 3 - 10")
    private String writer;
    private int boardId;

    public PostJpaDto(int id, String title, String content, String writer, int boardId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
    }

    public PostJpaDto() {

    }
}
