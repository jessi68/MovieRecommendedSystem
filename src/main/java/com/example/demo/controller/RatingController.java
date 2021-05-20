package com.example.demo.controller;

import com.example.demo.domain.Rating;
import com.example.demo.domain.RatingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
    private final RatingRepository ratingRepository;


    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/ratings/{movie_id}")
    int totalRatingBy(@PathVariable int movie_id) {
        return ratingRepository.totalRatingsFindBy(movie_id);
    }

}

