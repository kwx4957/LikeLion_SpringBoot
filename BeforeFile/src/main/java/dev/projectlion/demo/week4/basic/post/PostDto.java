package dev.projectlion.demo.week4.basic.post;

import lombok.*;

@Data
public class PostDto {
    private int id ;
    private String title;
    private String content;
    private String writer;
    private String password;

    public PostDto(int id ,String title, String content, String writer, String password) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }


}
