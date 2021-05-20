package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRepository extends JpaRepository<Age, Integer> {

    Age findByRepresentative(Integer representative);
}
