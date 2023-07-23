package com.example.restapi2.services;

import com.example.restapi2.dto.NewUserDto;
import com.example.restapi2.dto.UserDto;
import com.example.restapi2.dto.UsersDto;
import com.example.restapi2.models.User;

public interface UsersService {
    UserDto addUser(NewUserDto NewUser);

    UsersDto getAllUsers();
}
