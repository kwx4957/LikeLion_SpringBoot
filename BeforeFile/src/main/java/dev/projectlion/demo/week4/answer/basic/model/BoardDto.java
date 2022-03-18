package dev.projectlion.demo.week4.answer.basic.model;

import lombok.Data;

@Data
public class BoardDto {
    private Long id;
    private String name;

    public BoardDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
