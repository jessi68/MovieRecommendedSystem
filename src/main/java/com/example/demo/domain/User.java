package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="member")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Column
    String gender;

    @Column
    Age age;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    Occupation occupation;

    @Column(name = "zip_code")
    String zipCode;

    @OneToMany()
    @JoinColumn(name = "user_id")
    Set<Rating> ratings = new HashSet<>();

}
