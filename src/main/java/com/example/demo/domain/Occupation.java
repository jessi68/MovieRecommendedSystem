package com.example.demo.domain;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name="occupation")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String occupation;

    @Column
    String code;
}
