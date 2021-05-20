package com.example.demo.loader;

import com.example.demo.domain.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
@Order(4)
@Transactional
public class UserLoader extends Loader implements ApplicationRunner {

    @Autowired
    private OccupationRepository occupationRepository;

    @Autowired
    private AgeRepository ageRepository;

    private static final int USER_INDEX = 0;
    private static final int GENDER_INDEX = 1;
    private static final int AGE_INDEX = 2;
    private static final int OCCUPATION_INDEX = 3;
    private static final int ZIP_CODE_INDEX = 4;

    public UserLoader() throws FileNotFoundException {
        Name ="users_data";
        func = new FunctionalInterface() {
            @Override
            public void saveEntity() {
                User user = new User();
                user.setUserId(Integer.parseInt(datas[USER_INDEX]));
                user.setGender(datas[GENDER_INDEX]);
                user.setAge(ageRepository.findByRepresentative(Integer.parseInt(datas[AGE_INDEX])));
                user.setOccupation(occupationRepository.findByCode(Integer.parseInt(datas[OCCUPATION_INDEX])));
                user.setZipCode(datas[ZIP_CODE_INDEX]);
                session.save(user);
            }
        };
    }

    /*@Override
    public void run(ApplicationArguments args) throws Exception {

    }*/
}
