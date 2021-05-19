package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RatingRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Rating add(Rating rating) {
        entityManager.persist(rating);
        return rating;
    }

    public void delete(Rating rating) {
        entityManager.remove(rating);
    }

    public List<Rating> findAll() {
        return entityManager.createQuery("select r from rating as r").getResultList();
    }

    public int totalRatingsFindBy(int movie_id) {
        int totalScore = 0;
        List<Rating> ratings = entityManager.createQuery("select r from rating as r join r.movie as m where m.id = #{#movie_id}").getResultList();

        totalScore = ratings.stream()
                            .map(Rating::getScore)
                            .collect(Collectors.summingInt(Integer::intValue));
        return totalScore;
    }
    //public List<>
}
