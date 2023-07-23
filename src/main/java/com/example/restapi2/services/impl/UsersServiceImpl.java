package com.example.restapi2.services.impl;

import com.example.restapi2.dto.NewUserDto;
import com.example.restapi2.dto.UserDto;
import com.example.restapi2.dto.UsersDto;
import com.example.restapi2.models.User;
import com.example.restapi2.repositories.UsersRepository;
import com.example.restapi2.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.restapi2.dto.UserDto.from;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED)
                .build();

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UsersDto getAllUsers() {
        List<User> users = usersRepository.findAll();
        return UsersDto.builder()
                .users(from(users))
                .count(users.size())
                .build();
    }
}
