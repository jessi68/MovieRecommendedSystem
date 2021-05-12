package com.example.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    //Page<Movie> findByTitleContains(String title, Pageable pageable);

    //long countByTitleContains(String title);

}
