package com.example.demo.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    @Rollback(false)
    public void crud() {
        // Given
        Movie movie = new Movie();
        movie.setTitle("hello spring boot common");

        assertThat(movie.getId()).isNull();

        // When
        Movie newMovie = movieRepository.save(movie);

        //Then
        assertThat(newMovie.getId()).isNotNull();

        /*
        //When
        List<Movie> movies = movieRepository.findAll();
        //Then
        assertThat(movies.size()).isEqualTo(1);
        assertThat(movies).contains(movie);

        //When
        Page<Movie> page = movieRepository.findAll(PageRequest.of(0, 10));

        //Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);
        */
        // When
        /*page = movieRepository.findByTitleContains("spring", PageRequest.of(1, 10));
        //Then
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getSize()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(1);*/


    }
}