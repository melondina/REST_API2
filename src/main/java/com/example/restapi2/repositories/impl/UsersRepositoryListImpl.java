package com.example.restapi2.repositories.impl;

import com.example.restapi2.models.User;
import com.example.restapi2.repositories.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryListImpl implements UsersRepository {
    private static List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            user.setId((long) users.size() + 1); // id пользователя - его порядковый номер в списке
            users.add(user);
        } else {
            // TODO: если бы это была база данных или файл, то нужно было бы обновить данные в хранилище
            // обновляем, но тут этого делать не нужно, потому что это список объектов
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findById(Long id) {
        for(User user : users) {
            if( user.getId().equals(id)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @Override
    public void clear() {
        users.clear();
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
