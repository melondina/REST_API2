package com.example.restapi2.controllers;

import com.example.restapi2.controllers.api.UsersApi;
import com.example.restapi2.dto.NewUserDto;
import com.example.restapi2.dto.UpdateUserDto;
import com.example.restapi2.dto.UserDto;
import com.example.restapi2.dto.UsersDto;
import com.example.restapi2.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController

public class UsersController implements UsersApi {

    private final UsersService usersService;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        return usersService.addUser(newUser);
    }
    @Override
    public UsersDto getAllUsers() {
        return usersService.getAllUsers();
    }

    @Override
    public UserDto deleteUser(Long userId) {
        return usersService.deleteUser(userId);
    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
        return usersService.updateUser(userId, updateUser);
    }

    @Override
    public UserDto getUser(Long userId) {
        return usersService.getUser(userId);
    }
}
