package dev.projectlion.demo.week6.basic.entity;

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
            targetEntity = dev.projectlion.demo.week6.basic.entity.BoardEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "boardId")
    private BoardEntity boardEntity;
}
