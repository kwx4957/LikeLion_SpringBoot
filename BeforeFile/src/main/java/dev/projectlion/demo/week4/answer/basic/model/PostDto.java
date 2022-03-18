package dev.projectlion.demo.week4.answer.basic.model;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String password;
    private Long boardId;

    public PostDto(Long id, String name, String content, String writer, String password, Long boardId) {
        this.id = id;
        this.title = name;
        this.content = content;
        this.writer = writer;
        this.password = password;
        this.boardId = boardId;
    }

    public PostDto passwordMasked(){
        return new PostDto(
                this.id,
                this.title,
                this.content,
                this.writer,
                "*****",
                this.boardId
        );
    }
}
