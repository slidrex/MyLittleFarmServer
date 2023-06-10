package com.example.PayDayServer.authentication.repository;

import com.example.PayDayServer.authentication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
}
