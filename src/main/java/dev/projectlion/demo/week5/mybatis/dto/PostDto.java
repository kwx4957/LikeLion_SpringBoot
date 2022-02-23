package dev.projectlion.demo.week5.mybatis.dto;

import lombok.Data;

@Data
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private int board;
}
