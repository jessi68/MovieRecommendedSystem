package com.example.demo.domain;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;



@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    // repository 중 내가 구현하고 싶은 함수만 구현 가능
    <E extends T> E save(@NonNull E entity); // parameter 받는 거 보도 assert check 함

    List<T> findAll();

    long count();

    @Nullable // return type 이 null 일 수 있다.
    <E extends T> E findById(Id id);


}
