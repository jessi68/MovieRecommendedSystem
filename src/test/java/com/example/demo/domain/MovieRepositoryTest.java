package com.example.demo.domain;

import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    @Rollback(false)
    public void crud() throws IllegalAccessException, ExecutionException, InterruptedException {
        // Given
        /*Movie movie = new Movie();
        movie.setTitle("hello spring boot common");

        assertThat(movie.getId()).isNull();

        // When
        Movie newMovie = movieRepository.save(movie);

        //Then
        assertThat(newMovie.getId()).isNotNull();*/

        Optional<Movie> byId = movieRepository.findById(100l);
        assertThat(byId).isEmpty();
        Movie movie = byId.orElse(new Movie());
        //movieRepository.save(null);
        Movie movie1 = byId.orElseThrow(IllegalAccessException::new);

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

        Movie movie3 = new Movie();
        movie3.setTitle("disney");
        movie3.setLikeCount(100);
        movieRepository.save(movie3);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"));
        ListenableFuture<List<Movie>> movies = movieRepository.findByTitleContainsIgnoreCase("Disney", pageRequest);
        
        List<Movie> m = movies.get();

        m.forEach(System.out::println);
       // assertThat(movies.size()).isEqualTo(1);

        // assertThat 이 return 하는 객체는 hasFieldOrPropertyWithvalue(property, value) 라는 멤버함수 가짐
    }
}