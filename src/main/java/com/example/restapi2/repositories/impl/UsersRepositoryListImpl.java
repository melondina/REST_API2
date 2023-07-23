package com.example.restapi2.repositories.impl;

import com.example.restapi2.models.User;
import com.example.restapi2.repositories.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepositoryListImpl implements UsersRepository {
    private static List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        user.setId((long) users.size());
        users.add(user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void clear() {
        users.clear();
    }
}
