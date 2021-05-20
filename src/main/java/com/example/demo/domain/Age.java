package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="age")
public class Age {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer representative;

    @Column(columnDefinition = "Integer default 0")
    private Integer minAge;

    @Column(columnDefinition = "Integer default 145")
    private Integer maxAge;

}
