package com.example.restapi2.controllers;

import com.example.restapi2.dto.NewUserDto;
import com.example.restapi2.dto.UserDto;
import com.example.restapi2.dto.UsersDto;
import com.example.restapi2.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody NewUserDto newUser) {
        return usersService.addUser(newUser);
    }

    @GetMapping
    public UsersDto getAllUsers() {
        return usersService.getAllUsers();
    }
}
