package com.example.demo.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="occupation")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String job;

    @Column
    Integer code;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "occupation_id")
    List<User> users;
}
