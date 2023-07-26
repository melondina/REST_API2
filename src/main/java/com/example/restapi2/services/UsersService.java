package com.example.restapi2.services;

import com.example.restapi2.dto.NewUserDto;
import com.example.restapi2.dto.UpdateUserDto;
import com.example.restapi2.dto.UserDto;
import com.example.restapi2.dto.UsersDto;


public interface UsersService {
    UserDto addUser(NewUserDto NewUser);

    UsersDto getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);
}
