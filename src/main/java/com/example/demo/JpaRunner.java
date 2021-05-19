package com.example.demo;


import com.example.demo.domain.Movie;
import com.example.demo.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    //@Autowired
    //MovieRepository movieRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Movie movie = new Movie();
        movie.setUsername("souyoollkkn1");
        movie.setTitle("titttanic");

        entityManager.persist(movie);

        /*특정 movie에 대한 rating 구하기
        1. rating table에서 특정 movidID에 대한 rating 값을 읽어옴

        특정 movie와 특정 user group에 대한 rating 구하기
        1. user table에서 특정 user group에 속하는 userID
        2. 해당 userID와 특정 movieID에 해당하는 rating 값을 합함

        영화 제목을 받아서 비슷한 영화 추천*/
        // 특정 젠더 특정 id 특정 occupation
        String name = "I am the sam";

        Movie new_movie = new Movie();
        new_movie.setLikeCount(0);
        new_movie.setUsername("souyooon");
        new_movie.setTitle(name);
        entityManager.persist(new_movie);

        Movie findMovie = entityManager.find(Movie.class, 1);
        //System.out.println(findMovie);
        System.out.println("findMovie=" + findMovie.getUsername() + "likecCount" + findMovie.getLikeCount());

        List<Movie> movies = entityManager.createQuery("select m from Movie m", Movie.class).getResultList();

        System.out.println("size of movie is" + movies.size());

        entityManager.remove(new_movie);




        /*Movie movie2 = new Movie();
        movie2.setTitle("present");
        movie2.getGenres().add(genre);
        movie2.setUsername("souyoon");
        movieRepository.save(movie2);*/
    }
}