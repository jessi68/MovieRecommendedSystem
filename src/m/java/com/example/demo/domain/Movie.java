package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    int movieId;

    @Column(unique = true, columnDefinition = "varchar(255) default 'seoyoon'")
    private String username;

    @Column(nullable = false, unique = true)
    private String title;

    private Integer likeCount;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "movie_id")
    private Set<Genre> genres = new HashSet<>();

    @Column
    @OneToMany
    Set<Rating> ratings = new HashSet<>();

}