package com.example.restapi2.services.impl;

import com.example.restapi2.dto.NewUserDto;
import com.example.restapi2.dto.UpdateUserDto;
import com.example.restapi2.dto.UserDto;
import com.example.restapi2.dto.UsersDto;
import com.example.restapi2.exeptions.ForbiddenOperationException;
import com.example.restapi2.exeptions.NotFoundException;
import com.example.restapi2.models.User;
import com.example.restapi2.repositories.UsersRepository;
import com.example.restapi2.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public UserDto deleteUser(Long userId) {

        User user = getUserOrThrow(userId);

        usersRepository.delete(user);


        return from(user);
    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
        User user = getUserOrThrow(userId); // нашли пользователя

        if (updateUser.getNewRole().equals("ADMIN")) {
            throw new ForbiddenOperationException("Cannot make an administrator");
        }

        // обновляем ему поля
        user.setState(User.State.valueOf(updateUser.getNewState()));
        user.setRole(User.Role.valueOf(updateUser.getNewRole()));

        usersRepository.save(user); // вместо отдельно update можно использовать save

        return from(user);
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id <" + userId + "> not found"));
    }
}
