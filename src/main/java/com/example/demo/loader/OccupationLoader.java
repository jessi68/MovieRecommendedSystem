package com.example.demo.loader;


import com.example.demo.domain.Movie;
import com.example.demo.domain.Occupation;
import com.example.demo.domain.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;

@Component
@Transactional
@Order(2)
public class OccupationLoader extends Loader implements ApplicationRunner {

    private static final int CODE_INDEX = 0;
    private static final int JOB_INDEX = 1;

    public OccupationLoader() throws FileNotFoundException {
        Name = "occupations_data";
        func = new FunctionalInterface() {
            @Override
            public void saveEntity() {
                Occupation occupation = new Occupation();
                occupation.setCode(Integer.parseInt(datas[CODE_INDEX]));
                occupation.setJob(datas[JOB_INDEX]);
                session.save(occupation);
            }
        };
    }

    /*@Override
    public void run(ApplicationArguments args) throws Exception {

    }*/
}
