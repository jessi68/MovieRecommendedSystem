package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAsync // 테스트 코드 만들기가 너무 지저분함. 사용 비추
public class MovieJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieJpaApplication.class, args);
	}

}
