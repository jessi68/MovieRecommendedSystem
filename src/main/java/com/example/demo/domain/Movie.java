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

    @Column(name ="movie_id")
    Integer movieId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "integer default 1")
    private Integer likeCount;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "movie_id")
    private Set<Genre> genres = new HashSet<>();

    @OneToMany
    @Column(name = "movie_id")
    Set<Rating> ratings = new HashSet<>();

}