package com.example.restapi2.repositories;

import com.example.restapi2.models.User;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UsersRepository {
    void save (User user);

    List<User> findAll();

    void clear();
}
