package dev.projectlion.demo.week5.jpa;

import lombok.Data;

@Data
public class PostJpaDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private int boardId;

    public PostJpaDto(int id, String title, String content, String writer, int boardId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
    }
}
