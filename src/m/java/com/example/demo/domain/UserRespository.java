package com.example.demo.domain;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRespository extends MyRepository<User, Long>{


}
