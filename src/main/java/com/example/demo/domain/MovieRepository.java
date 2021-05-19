package com.example.demo.domain;


import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //Page<Movie> findByTitleContains(String title, Pageable pageable);

    //long countByTitleContains(String title);
    // jpa 가 method 이름 분석해서 쿼리를 만들어줌 (1)
    // 방법 (2) 아랫 줄( 미리 정의해둔 쿼리 찾아 사용하기 )
    // nativeQuery: sql, nativequery 를 true 로 설정안해주면 jql써야함
    // (2) 먼저 시도하고 정의해둔 쿼리없으면 (1) 시도 (default).
    //@Query(value = "SELECT c FROM movie as m", nativeQuery = true)

    // 이 메소드 실행을 별도의 스레드에게 실행
    // nonblocking code 로 만들려면
    List<Movie> findByTitleContainsIgnoreCase(String title, Pageable pageable);

    //Page<Movie> findByLikeCountGreaterThan(String title);


}