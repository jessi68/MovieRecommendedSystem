package com.example.demo.loader;

import com.example.demo.domain.Genre;
import com.example.demo.domain.Movie;
import com.example.demo.domain.User;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
@Order(1)
public class MovieLoader extends Loader implements ApplicationRunner{


    private static final String REGEX_FOR_GENRES = "\\|";

    private static final int ID_INDEX = 0;
    private static final int TITLE_INDEX = 1;
    private static final int GENRES_INDEX = 2;

    private void makeGenresOf(Movie movie) {
        String [] genres = datas[GENRES_INDEX].split(REGEX_FOR_GENRES);
        for(String name: genres) {
            Genre g = new Genre();
            g.setName(name);
            session.save(g);
            movie.getGenres().add(g);
        }
        session.save(movie);
    }

    private Movie makeMovie() {
        Movie movie = new Movie();
        movie.setMovieId(Integer.parseInt(datas[ID_INDEX]));
        movie.setTitle(datas[TITLE_INDEX]);
        return movie;
    }

    public MovieLoader() throws FileNotFoundException {
        Name = "movies_data";
        func = new FunctionalInterface() {
            @Override
            public void saveEntity() {
                Movie movie = makeMovie();
                makeGenresOf(movie);
            }
        };
    }

    /*@Override
    public void run(ApplicationArguments args) throws Exception {

    }*/
}
