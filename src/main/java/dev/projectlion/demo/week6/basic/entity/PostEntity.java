package dev.projectlion.demo.week6.basic;

import javax.persistence.*;

@Entity
@Table(name = "Post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String password;
    private Long boardId;

}
