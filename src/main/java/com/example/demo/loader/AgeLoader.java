package com.example.demo.loader;

import com.example.demo.domain.Age;
import com.example.demo.domain.Rating;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;

@Component
@Transactional
@Order(3)
public class AgeLoader extends Loader implements ApplicationRunner {

    static final int PRIMARY_AGE_INDEX = 0;
    static final int LEAST_AGE_INDEX = 1;
    static final int MOST_AGE_INDEX = 2;

    public AgeLoader() throws FileNotFoundException {
        Name ="ages_data";
        func = new FunctionalInterface() {
            @Override
            public void saveEntity() {
                Age age = new Age();
                age.setRepresentative(Integer.parseInt(datas[PRIMARY_AGE_INDEX]));
                age.setMaxAge(Integer.parseInt(datas[MOST_AGE_INDEX]));
                age.setMinAge(Integer.parseInt(datas[LEAST_AGE_INDEX]));
                session.save(age);
            }
        };
    }
}
