package com.example.demo.loader;

import com.example.demo.domain.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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

@Component
@Transactional
@Order(4)
// application Runner class 를 상속받으면, spring boot 서버 실행 전에 실행이 됨. 전처리 같은 느낌.
public class RatingLoader extends Loader implements ApplicationRunner {

    static final int USER_INDEX = 0;
    static final int MOVIE_INDEX = 1;
    static final int SCORE_INDEX = 2;
    static final int TIME_INDEX = 3;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public RatingLoader() throws FileNotFoundException {
        Name ="ratings_data";
        func = new FunctionalInterface() {
            @Override
            public void saveEntity() {
                Rating rating = new Rating();
                rating.setScore(Integer.parseInt(datas[SCORE_INDEX]));
                rating.setMovie(movieRepository.findByMovieId(Integer.parseInt(datas[MOVIE_INDEX])));
                rating.setUser(userRepository.findByUserId(Integer.parseInt(datas[USER_INDEX])));
                rating.setTimeStamp(datas[TIME_INDEX]);
                session.save(rating);
            }
        };
    }



}
