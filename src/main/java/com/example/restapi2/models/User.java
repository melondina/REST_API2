package com.example.restapi2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public enum Role {
        ADMIN,
        USER
    }

    public enum State {
        NOT_CONFIRMED,
        CONFIRMED,
        BANNED,
        DELETED
    }


    private Long id;

    private String email;
    private String password;
    private Role role;
    private State state;

    private List<Event> events;

}
