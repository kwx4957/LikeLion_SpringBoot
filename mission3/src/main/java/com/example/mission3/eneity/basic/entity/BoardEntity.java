package com.example.mission3.eneity.basic.entity;

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

    @Column(name = "board_name")
    private String name;

    @OneToMany(
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY
    )
    private List<PostEntity> postEntityList = new ArrayList<>();
}
