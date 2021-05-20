package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="age")
public class Age {

    @Column
    private int representative;

    @Column(columnDefinition = "integer default 0")
    private int minAge;

    @Column(columnDefinition = "integer default 145")
    private int maxAge;

}
