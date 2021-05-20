package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<Occupation, Integer> {
    Occupation findByCode(int code);
}
