package dev.projectlion.demo.week6.basic.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boardName")
    private String name;

    @OneToMany(
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY
    )
    private List<PostEntity> postEntityList = new ArrayList<>();
}
