package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int user_id);

    @Query("select movie from User u where u.firstname = :#{#customer.firstname}")
    List<Movie> findUsersByCustomersFirstname(@Param("member") User user);
}
