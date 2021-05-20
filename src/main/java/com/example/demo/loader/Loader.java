package com.example.demo.loader;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.*;

@Transactional
public class Loader implements ApplicationRunner {

    @PersistenceContext
    protected EntityManager entityManager;
    protected String Name;
    protected static final String PATH = "C:\\Users\\GTHR\\Downloads\\spring-in-action-master\\spring-in-action-master\\chapter03\\MovieSystem\\src\\main\\" +
            "resources\\static\\";

    // 세션을 사용하려면 세션이 사용된 함수가 atomic 하게 실행되어야 해서 transactional annotation 이 필요함.
    protected Session session;
    protected FunctionalInterface func;
    protected File file;
    protected static FileReader fileReader;
    protected static BufferedReader bufferedReader;

    protected String[] datas;

    protected final String REGEX = "::";

    public void initConfig(String Name) {
        file = new File(PATH + Name);
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(fileReader);
        session = entityManager.unwrap(Session.class);
    }

    public void loadAndSave() throws IOException {
        String line;
        while((line = bufferedReader.readLine()) != null) {
            datas = line.split(REGEX);
            func.saveEntity();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.initConfig(Name);
        this.loadAndSave();
    }

}
