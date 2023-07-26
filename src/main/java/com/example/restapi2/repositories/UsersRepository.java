package com.example.restapi2.repositories;

import com.example.restapi2.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface UsersRepository {
    void save (User user);

    List<User> findAll();

    Optional<User> findById(Long Id);

    //TODO: убрать метод, когда подключим базу данных
    void clear();

    void delete(User user);
}
