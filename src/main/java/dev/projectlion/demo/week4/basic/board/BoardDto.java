package dev.projectlion.demo.week4.basic.board;

import lombok.*;

@Data
public class BoardDto {
    private int id;
    private String board;
    private int postId;

    public BoardDto(int id, String board, int postId) {
        this.id = id;
        this.board = board;
        this.postId = postId;
    }
}
