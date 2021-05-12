package com.example.demo;


import com.example.demo.domain.Genre;
import com.example.demo.domain.Movie;
import com.example.demo.domain.MovieRepository;
import com.example.demo.domain.RatingRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    MovieRepository movieRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Movie movie = new Movie();
        movie.setUsername("souyookkn1");
        movie.setTitle("titanic");
        entityManager.persist(movie);

        Genre genre = new Genre();
        genre.setGenre("adventure");

        movie.getGenres().add(genre);
        Session session = entityManager.unwrap(Session.class);
        session.save(movie);
        session.save(genre);


        //Session session = entityManager.unwrap(Session.class);
        //session.save(movie);

        //쿼리 생성
        entityManager.createNativeQuery("Select * from movie", Movie.class);
        //entityManager.createNamedQuery("all movie", Movie.class);
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> query = builder.createQuery(Movie.class);
        Root<Movie> root = query.from(Movie.class);
        query.select(root);

        List<Movie> movies = entityManager.createQuery(query).getResultList();
        movies.forEach(System.out::println);



        /*특정 movie에 대한 rating 구하기
        1. rating table에서 특정 movidID에 대한 rating 값을 읽어옴

        특정 movie와 특정 user group에 대한 rating 구하기
        1. user table에서 특정 user group에 속하는 userID
        2. 해당 userID와 특정 movieID에 해당하는 rating 값을 합함*/

        // 특정 젠더 특정 id 특정 occupation

        String rating_sql = "select SUM(score) from rating where rating.movie_id = ;\n";
        //String user_group_sql = "select "

        Movie movie2 = new Movie();
        movie2.setTitle("present");
        movie2.getGenres().add(genre);
        movie2.setUsername("souyoon");
        movieRepository.save(movie2);
    }
}