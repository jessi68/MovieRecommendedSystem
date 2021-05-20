package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    String name;

   @ManyToOne
   @JoinColumn(name = "movie_id")
   Movie movie;


}
