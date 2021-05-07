package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    int userId;

    @Column
    String gender;

    @Column
    int age;

    @Column
    Occupation occupation;

    @Column
    int zip_code;

    @Column
    @OneToMany
    Set<Rating> ratings = new HashSet<>();

}
