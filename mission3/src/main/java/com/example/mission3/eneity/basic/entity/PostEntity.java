package com.example.mission3.eneity.basic.entity;

import dev.projectlion.demo.week5.jpa.entity.BoardEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    private UserEntity writer;
    private String password;

    @ManyToOne(
            targetEntity = com.example.mission3.eneity.basic.entity.BoardEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "boardId")
    private BoardEntity boardEntity;
}
