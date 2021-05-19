package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    //public List<>
}
