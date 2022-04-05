package com.example.auth.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String role;
}
