package com.example.demo.loader;

import com.example.demo.domain.Genre;
import com.example.demo.domain.Movie;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class MovieLoader implements ApplicationRunner {

    private static final String MOVIE_PATH = "C:\\Users\\GTHR\\Downloads\\spring-in-action-master\\spring-in-action-master\\chapter03\\MovieSystem\\src\\m\\" +
            "resources\\static\\movies_data";

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File movies = new File(MOVIE_PATH);
        FileReader fileReader = new FileReader(movies);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Session session = entityManager.unwrap(Session.class);
        String[] elements;
        String [] genres;
        String line = "";

        while(true) {
            line = bufferedReader.readLine();
            if(line == null){
                break;
            }

            elements = line.split("::");
            Genre genre = new Genre();
            genres = elements[2].split("\\|");

            for(String name: genres) {
                genre.setName(name);
            }
            session.save(genre);
            //elements = line.split("::");
            //Movie movie = new Movie();/
            // movie.setTitle(elements[1]);

            //entityManager.persist(movie);
            //session.save(movie);
        }

    }
}
