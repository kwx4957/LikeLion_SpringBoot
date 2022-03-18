package dev.projectlion.demo.week5.jpa.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="post")
public class PostEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 값 설정 db에 역임하기
    private Long id;
    private String title;
    private String content;
    private String writer;

    @ManyToOne(
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;
}
