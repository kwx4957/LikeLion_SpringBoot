package dev.projectlion.demo.week6.basic.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer age;
    String country;
    @OneToMany(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY
    )
    private List<PostEntity> postEntityList = new ArrayList<>();

}
